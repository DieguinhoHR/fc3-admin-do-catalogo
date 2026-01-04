package com.fullcycle.admin.catalogo.application.category.create;

import com.fullcycle.admin.catalogo.domain.category.CategoryGateway;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateCategoryUseCaseTest {

    /**
     * Pensa tudo que a gente quer testar
     *
     * Teste do caminho feliz (comando valido e cria categoria)
     * Teste passando uma proprieda inválida (name)
     * Teste criando uma categoria inativa
     * Teste simulando um erro generico vindo do gateway
     */
    @Test
    void givenAValidCommand_whenCallsCreateCategory_shouldReturnCategoryId() {
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        // é um padrão que da uma semantica para este padrão (implementa o pattern command - recebe um comando para executar categorai)
        final var aCommand = CreateCategoryCommand.with(expectedName, expectedDescription, expectedIsActive);
        final CategoryGateway categoryGateway = mock(CategoryGateway.class);

        Mockito.when(categoryGateway.create(any()))
                .thenAnswer(returnsFirstArg());

        final var useCase = new DefaultCreateCategoryUseCase(categoryGateway);

        final var actualOutput = useCase.execute(aCommand);

        assertNotNull(actualOutput);
        assertNotNull(actualOutput.id());

        Mockito.verify(categoryGateway, times(1)).create(Mockito.argThat(aCategory ->
            Objects.equals(expectedName, aCategory.getName())
                && Objects.equals(expectedDescription, aCategory.getDescription())
                && Objects.equals(expectedIsActive, aCategory.isActive())
                && Objects.nonNull(aCategory.getId())
                && Objects.nonNull(aCategory.getCreatedAt())
                && Objects.nonNull(aCategory.getUpdatedAt())
                && Objects.isNull(aCategory.getDeletedAt())
        ));
    }
}

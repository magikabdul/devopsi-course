package basic;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GradeTest {

    @Test
    void shouldThrowExceptionWhenArrayIsEmpty() {
        //given
        final int[] array = {};
        Grade grade = new Grade(array);

        //when
        assertThatThrownBy(grade::averageScore)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("No value present");
    }

    @Test
    void shouldReturnGradeA() {
        //given
        final int[] array = {6, 5, 4, 3, 2};
        Grade grade = new Grade(array);

        //when
        String result = grade.averageScore();

        //then
        assertThat(result).isEqualTo("A = Super");
    }

    @Test
    void shouldReturnGradeB() {
        //given
        final int[] array = {4, 5, 3, 3, 2};
        Grade grade = new Grade(array);

        //when
        String result = grade.averageScore();

        //then
        assertThat(result).isEqualTo("B = Middling");
    }

    @Test
    void shouldReturnGradeC() {
        //given
        final int[] array = {1, 5, 4, 3, 2, 1, 2, 2, 3};
        Grade grade = new Grade(array);

        //when
        String result = grade.averageScore();

        //then
        assertThat(result).isEqualTo("C = Poorly");
    }
}

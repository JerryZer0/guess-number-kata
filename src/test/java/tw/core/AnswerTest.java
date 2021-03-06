package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.AnswerFormatIncorrectException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by jxzhong on 2017/9/23.
 */
public class AnswerTest {
    private Answer actualAnswer;

    @BeforeEach
    public void setUp() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_return_answer_with_numberList_init_given_1324(){
        assertThat(actualAnswer.toString(),is("1 2 3 4"));
    }

    @Test
    public void should_pass_validate_when_input_is_1324(){
        Answer input = Answer.createAnswer("1 3 2 4");
        try {
            input.validate();
        }catch (AnswerFormatIncorrectException e){
            System.out.println("It should not throw exception!!");
        }
    }

    @Test
    public void should_failed_when_input_is_10413(){
        Answer input = Answer.createAnswer("10 4 1 3");
        try {
            input.validate();
        }catch (AnswerFormatIncorrectException e){
            System.out.println("It should throw exception!!");
        }
    }

    @Test
    public void should_return_2A2B_given_1324(){
        Answer input = Answer.createAnswer("1 3 2 4");
        assertThat(actualAnswer.check(input).getValue(),is("2A2B"));
    }

    @Test
    public void should_return_1_given_index_of_2(){
        assertThat(actualAnswer.getIndexOfNum("2"),is(1));
    }

    @Test
    public void should_return_the_String_of_acturalAnswer(){
        assertThat(actualAnswer.toString(),is("1 2 3 4"));
    }
}
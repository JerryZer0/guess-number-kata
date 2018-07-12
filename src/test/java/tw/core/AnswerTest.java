package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.model.Record;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.sun.javaws.JnlpxArgs.verify;
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

//    @Test
//    public void should_return_the_collect_from_String(){
//        Integer input[] = new Integer[]{1, 2, 3, 4};
//        System.err.println(Answer.createAnswer("1 2 3 4"));
//        assertThat(Answer.createAnswer("1 2 3 4"),is(input));
//    }

    @Test
    public void should_return_2A2B_given_1324(){
        Answer input = Answer.createAnswer("1 3 2 4");
        assertThat(actualAnswer.check(input).getValue(),is("2A2B"));
    }

    @Test
    public void should_return_1_given_index_of_2(){
        assertThat(actualAnswer.getIndexOfNum("2"),is(1));
    }

}
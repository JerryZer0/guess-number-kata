package tw.core;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.OutOfGuessCountException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    private final Answer actualAnswer = Answer.createAnswer("1 2 3 4");
    private Game game;

    @BeforeEach
    public void setUp() throws Exception {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
    }

//    @Test
//    public void should_return_FAIL_when_input_times_bigger_than_MAX_TIMES(){
//        GuessResult guessResult = new GuessResult("4A0B",actualAnswer);
//        List<GuessResult> guessResults = new ArrayList<>();
//        guessResults.add(guessResult);
//         assertThat(game.ch);
//
//    }

    @Test
    public void should_return_continue_when_input_times_smaller_than_MAX_TIMES(){
        Answer actualAnswer = Answer.createAnswer("1 5 3 4");
        try{
            game.guess(actualAnswer);
        }catch (OutOfGuessCountException e){
        }
        assertThat(game.checkStatus(),is("continue"));
    }

    @Test
    public void should_return_fail_when_input_times_bigger_than_MAX_TIMES(){
        Answer actualAnswer = Answer.createAnswer("1 5 3 4");
        try{
            game.guess(actualAnswer);
            game.guess(actualAnswer);
            game.guess(actualAnswer);
            game.guess(actualAnswer);
            game.guess(actualAnswer);
            game.guess(actualAnswer);
        }catch (OutOfGuessCountException e){
        }
        assertThat(game.checkStatus(),is("fail"));
    }
    @Test
    public void should_return_success_when_input_times_bigger_than_MAX_TIMES(){
        Answer actualAnswer = Answer.createAnswer("1 2 3 4");
        try{
            game.guess(actualAnswer);
        }catch (OutOfGuessCountException e){
        }
        assertThat(game.checkStatus(),is("success"));
    }

    @Test
    public void should_get_the_success_status_when_guess_input_is_correct() throws Exception {

        //given
//        excuteSuccessGuess();
        GuessResult guess = game.guess(Answer.createAnswer("1 2 3 4"));
        //when
        //then
        assertThat(guess.getResult(), is("4A0B"));

    }


}

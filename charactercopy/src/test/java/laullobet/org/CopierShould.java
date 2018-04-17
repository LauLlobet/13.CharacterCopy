package laullobet.org;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CopierShould
{
    @Mock
    IDestination destinationMock;

    @Test
    public void should_read_from_source_till_a_line_jump()
    {
        SourceSpy sourceSpy = new SourceSpy("123456\nXXXXXXXXXXXX");
        Copier copier = new Copier(sourceSpy, destinationMock);

        copier.copy();

        assertThat( sourceSpy.getCalledNTimes(),is(7));
    }

    @Test
    public void should_write_on_destination_till_first_line(){

        SourceSpy sourceSpy = new SourceSpy("123456\nXXXXXXXXXXXX");
        Copier copier = new Copier(sourceSpy, destinationMock);

        copier.copy();

        Mockito.verify(destinationMock, times(6)).PutChar(any(char.class));
    }

}

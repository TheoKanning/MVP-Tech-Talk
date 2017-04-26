package theo.mvp.ui.signin;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.Observable;
import theo.mvp.api.SignInApi;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SignInPresenterTest {

    private SignInPresenter presenter;
    private SignInApi mockApi;
    private SignInView mockView;

    @Before
    public void setup(){
        mockApi = Mockito.mock(SignInApi.class);
        mockView = Mockito.mock(SignInView.class);

        presenter = new SignInPresenter(mockApi);
    }

    @Test
    public void logInSuccessful_displaySuccessMessage() {
        when(mockApi.signIn(anyString(), anyString())).thenReturn(Observable.just(true));

        presenter.attachView(mockView);
        presenter.submit("email", "password");

        verify(mockView).displaySuccess();
        verify(mockView, never()).displayError();
    }

    @Test
    public void logInFailed_displayErrorMessage() {
        when(mockApi.signIn(anyString(), anyString())).thenReturn(Observable.just(false));

        presenter.attachView(mockView);
        presenter.submit("email", "password");

        verify(mockView).displayError();
        verify(mockView, never()).displaySuccess();
    }
}

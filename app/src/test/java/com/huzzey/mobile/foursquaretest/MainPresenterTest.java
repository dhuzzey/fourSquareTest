package com.huzzey.mobile.foursquaretest;

import android.os.Handler;

import com.huzzey.mobile.foursquaretest.helpers.VolleyHelper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class MainPresenterTest {
    @Mock
    MainContract.View view;
    @Mock
    VolleyHelper helper;

    private MainPresenter presenter;

    //private EditText mMockedEditable;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(view, helper);
        //mMockedEditable = mock(EditText.class);
    }

    @Test
    public void testInitialState() throws Exception {
        presenter.onResume();
        verify(view).hideSpinner();
        verify(view).updateActionbar(R.string.actionBarDefault);
    }

    @Test
    public void testTypedLessThanThreeChars() throws Exception {
        //mMockedEditable.setText("te");
        presenter.afterTextChanged("te");
        verify(view).hideList();
        verify(view).hideSpinner();
        verify(view).updateActionbar(R.string.actionBarDefault);
    }

    @Test
    public void testTypeMorethanThreeChars() throws Exception {
        //mMockedEditable.setText("test");
        //when(mMockedEditable.getText()).thenReturn(new Editable.Factory.getInstance().newEditable("test"));
        //Handler handler = new Handler();
        when(new Handler().postDelayed(null, 0)).thenReturn(true);
        presenter.afterTextChanged("test");
        verify(view).hideList();
        verify(view).showSpinner();
    }
}
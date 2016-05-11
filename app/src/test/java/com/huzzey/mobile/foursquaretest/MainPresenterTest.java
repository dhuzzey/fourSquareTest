package com.huzzey.mobile.foursquaretest;

import android.widget.EditText;

import com.huzzey.mobile.foursquaretest.helpers.VolleyHelper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class MainPresenterTest {
    @Mock
    MainContract.View view;
    @Mock
    VolleyHelper helper;

    private MainPresenter presenter;

    private EditText mMockedEditable;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(view, helper);
        mMockedEditable = mock(EditText.class);
        mMockedEditable.setText("te");
    }

    @Test
    public void testInitialState() throws Exception {
        verify(view).hideSpinner();
        verify(view).updateActionbar(R.string.actionBarDefault);
    }

    @Test
    public void testTypedLessThanThreeChars() throws Exception {
        presenter.afterTextChanged(mMockedEditable.getText());
        verify(view).hideList();
        verify(view).hideSpinner();
        verify(view).updateActionbar(R.string.actionBarDefault);
    }
}
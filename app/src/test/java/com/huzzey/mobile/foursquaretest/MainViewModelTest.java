package com.huzzey.mobile.foursquaretest;

import com.huzzey.mobile.foursquaretest.datatypes.Items;
import com.huzzey.mobile.foursquaretest.model.GetDataMock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;

/**
 * Created by darren.huzzey on 11/05/16.
 */
public class MainViewModelTest {
    @Mock
    MainContract.View view;

    GetDataMock getData;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitialState() throws Exception {
        MainViewModel presenter = new MainViewModel(view, getData);
        presenter.onResume();
        verify(view).hideSpinner();
        verify(view).updateActionbar(R.string.actionBarDefault);
    }

    @Test
    public void testTypedLessThanThreeChars() throws Exception {
        MainViewModel presenter = new MainViewModel(view, getData);
        presenter.afterTextChanged("te");
        verify(view).hideList();
        verify(view).hideSpinner();
        verify(view).updateActionbar(R.string.actionBarDefault);
    }

    @Test
    public void testTypeMorethanThreeCharsPass() throws Exception {
        getData = new GetDataMock(GetDataMock.GETDATAPASS);
        MainViewModel presenter = new MainViewModel(view, getData);
        presenter.afterTextChanged("test");

        verify(view).updateList(new ArrayList<Items>());
        verify(view).hideSpinner();
        verify(view).updateActionbar("");
    }

    @Test
    public void testTypeMorethanThreeCharsFail() throws Exception {
        getData = new GetDataMock(GetDataMock.GETDATAFAIL);
        MainViewModel presenter = new MainViewModel(view, getData);
        presenter.afterTextChanged("test");

        verify(view).hideSpinner();
        verify(view).updateActionbar(R.string.actionBarDefault);
    }
}
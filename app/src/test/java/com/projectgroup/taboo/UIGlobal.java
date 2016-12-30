package com.projectgroup.taboo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by y50-70 on 30.12.2016.
 */

public class UIGlobal {

    private Global global;

    @Before
    public void setUp() {
        global = new Global();
    }

    @Test
    public void checkArrayFirstTeamNull() {
        Assert.assertEquals(null, global.getFirstTeam());
    }

    @Test
    public void checkArraySecondTeamNull() {
        Assert.assertEquals(null, global.getSecondTeam());
    }

    @Test
    public void checkArrayRedTeamEmpty() {
        Assert.assertEquals(0, global.getRedTeam().size());
    }

    @Test
    public void checkArrayBlueTeamEmpty() {
        Assert.assertEquals(0, global.getBlueTeam().size());
    }

}

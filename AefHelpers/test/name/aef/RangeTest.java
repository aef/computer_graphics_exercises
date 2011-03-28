/*
# Copyright © Alexander E. Fischer <aef@raxys.net>, 2010
#
# This file is part of INSERT NAME HERE.
 */

package name.aef;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander E. Fischer <aef@raxys.net>
 */
public class RangeTest {

    public RangeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetMaximum() {
        Range integerRange = new Range<Integer>(5, 23);
        assertEquals(integerRange.getMaximum(), 23);

        Range doubleRange = new Range<Double>(5.0, 23.0);
        assertEquals(doubleRange.getMaximum(), 23.0);

        Range bigDecimalRange = new Range<BigDecimal>(new BigDecimal("5.0"), new BigDecimal("23.0"));
        assertEquals(bigDecimalRange.getMaximum(), new BigDecimal("23.0"));
    }

    @Test
    public void testGetMinimum() {
        Range integerRange = new Range<Integer>(5, 23);
        assertEquals(integerRange.getMinimum(), 5);

        Range doubleRange = new Range<Double>(5.0, 23.0);
        assertEquals(doubleRange.getMinimum(), 5.0);

        Range bigDecimalRange = new Range<BigDecimal>(new BigDecimal("5.0"), new BigDecimal("23.0"));
        assertEquals(bigDecimalRange.getMinimum(), new BigDecimal("5.0"));
    }

    @Test
    public void testSetMaximum() {
        Range integerRange = new Range<Integer>(5, 23);
        integerRange.setMaximum(17);
        assertEquals(integerRange.getMaximum(), 17);

        Range doubleRange = new Range<Double>(5.0, 23.0);
        doubleRange.setMaximum(17.0);
        assertEquals(doubleRange.getMaximum(), 17.0);

        Range bigDecimalRange = new Range<BigDecimal>(new BigDecimal("5.0"), new BigDecimal("23.0"));
        bigDecimalRange.setMaximum(new BigDecimal("17.0"));
        assertEquals(bigDecimalRange.getMaximum(), new BigDecimal("17.0"));
    }

    @Test
    public void testSetMinimum() {
        Range integerRange = new Range<Integer>(5, 23);
        integerRange.setMinimum(17);
        assertEquals(integerRange.getMinimum(), 17);

        Range doubleRange = new Range<Double>(5.0, 23.0);
        doubleRange.setMinimum(17.0);
        assertEquals(doubleRange.getMinimum(), 17.0);

        Range bigDecimalRange = new Range<BigDecimal>(new BigDecimal("5.0"), new BigDecimal("23.0"));
        bigDecimalRange.setMinimum(new BigDecimal("17.0"));
        assertEquals(bigDecimalRange.getMinimum(), new BigDecimal("17.0"));
    }

    @Test
    public void testIsIncluded() {
        Range integerRange = new Range<Integer>(2, 4);
        assertFalse(integerRange.isIncluded(0));
        assertFalse(integerRange.isIncluded(1));
        assertTrue(integerRange.isIncluded(2));
        assertTrue(integerRange.isIncluded(3));
        assertTrue(integerRange.isIncluded(4));
        assertFalse(integerRange.isIncluded(5));
        assertFalse(integerRange.isIncluded(6));

        Range doubleRange = new Range<Double>(2.0, 4.0);
        assertFalse(doubleRange.isIncluded(1.0));
        assertFalse(doubleRange.isIncluded(1.999999));
        assertTrue(doubleRange.isIncluded(2.0));
        assertTrue(doubleRange.isIncluded(3.0));
        assertTrue(doubleRange.isIncluded(4.0));
        assertFalse(doubleRange.isIncluded(4.000001));
        assertFalse(doubleRange.isIncluded(5.0));

        Range bigDecimalRange = new Range<BigDecimal>(new BigDecimal("2.0"), new BigDecimal("4.0"));
        assertFalse(bigDecimalRange.isIncluded(new BigDecimal("1.0")));
        assertFalse(bigDecimalRange.isIncluded(new BigDecimal("1.999999")));
        assertTrue(bigDecimalRange.isIncluded(new BigDecimal("2.0")));
        assertTrue(bigDecimalRange.isIncluded(new BigDecimal("3.0")));
        assertTrue(bigDecimalRange.isIncluded(new BigDecimal("4.0")));
        assertFalse(bigDecimalRange.isIncluded(new BigDecimal("4.000001")));
        assertFalse(bigDecimalRange.isIncluded(new BigDecimal("5.0")));
    }
}
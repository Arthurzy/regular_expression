package cn.com.lee.regx;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PathValidationTest 
{
    @Test
    public void validPath()
    {

		String path = "/ecurep/sf/TS001/123/TS001123879/0-all_data/testfile.zip_unpack/testfile";
        assertTrue( PathValidation.isValidatePath(path) );
        path = "/ecurep/sf/TS001/123/TS001123879/0-all_data";
        assertTrue( PathValidation.isValidatePath(path) );
        path = "/ecurep/2022-03-14/sf/TS001/123/TS001123879/0-all_data";
        assertTrue( PathValidation.isValidatePath(path) );
    }
    

    @Test
    public void validDatePath()
    {

    	String path = "/1999-01-01/aaa/bbb";
        assertTrue( PathValidation.isValidatePath(path) );
    }

    @Test
    public void invalidDatePath() {
    	String path = "/1999-02-51/aaa/bbb";
    	assertFalse( PathValidation.isValidatePath(path) );
    }
    
    @Test
    public void validMailPath() {
		String path = "/b/mail20200728-133547-Peter_Heuchert/a";
        assertTrue( PathValidation.isValidatePath(path) );
        path = "/mail20200728-133547-Peter_Heuchert/a";
        assertTrue( PathValidation.isValidatePath(path) );
        path = "/aaa/bbb/mail20200728-133547-Peter_Heuchert";
        assertTrue( PathValidation.isValidatePath(path) );
        
    }
    
    @Test
    public void invalidMailPath() {
    	String path = "/aaa/bbb/mail20200788-133547-Peter_Heuchert";
    	assertFalse( PathValidation.isValidatePath(path) );
    	path = "/aaa/bbb/mail20200728-253547-Peter_Heuchert";
    	assertFalse( PathValidation.isValidatePath(path) );
    }
    
    @Test
    public void invalidPath() {
    	String path = null;
    	assertFalse( PathValidation.isValidatePath(path) );
    	path = "";
    	assertFalse( PathValidation.isValidatePath(path) );
    	path = "/ecurep/sf/TS001/123/TS001123879/support_files/testfile.zip_unpack/testfile";
    	assertFalse( PathValidation.isValidatePath(path) );
    }
}

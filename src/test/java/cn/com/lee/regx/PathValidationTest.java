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
    public void invalidPath() {
    	String path = null;
    	assertFalse( PathValidation.isValidatePath(path) );
    	path = "";
    	assertFalse( PathValidation.isValidatePath(path) );
    	path = "/ecurep/sf/TS001/123/TS001123879/support_files/testfile.zip_unpack/testfile";
    	assertFalse( PathValidation.isValidatePath(path) );
    }
    

    @Test
    public void validDatePath()
    {

    	String path = "/1999-01-01/aaa/bbb";
        assertTrue( PathValidation.isValidatePath(path) );
        String path1 = "/ecurep/sf/TS001/123/TS001123879/0-all_data/testfile.zip_unpack/testfile";
        assertTrue(PathValidation.isValidatePath(path1));
        String path2 = " /ecurep/sf/TS000/001/TS000001007/2020-10-15/testfile0-0010.0MB-342KLines-DUP0012.txt";
        assertTrue(PathValidation.isValidatePath(path2));
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
        String path3 = "/ecurep/sf/TS000/001/TS000001007/mail20190709-150113-0887-Peter_Heuchert/mail.html";
    	assertTrue( PathValidation.isValidatePath(path3) );
        
    }
    
    @Test
    public void invalidMailPath() {
    	String path1 = "/aaa/bbb/mail20200788-133547-Peter_Heuchert/";
    	assertFalse( PathValidation.isValidatePath(path1) );
    	String path2 = "/aaa/bbb/mail20200728-253567-Peter_Heuchert/";
    	assertFalse( PathValidation.isValidatePath(path2) ); 	
    }
    

}

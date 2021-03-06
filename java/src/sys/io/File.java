// Generated by Haxe 3.4.0
package sys.io;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class File extends haxe.lang.HxObject
{
	public File(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public File()
	{
		//line 25 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
		sys.io.File.__hx_ctor_sys_io_File(this);
	}
	
	
	public static void __hx_ctor_sys_io_File(sys.io.File __hx_this)
	{
	}
	
	
	public static sys.io.FileInput read(java.lang.String path, java.lang.Object binary)
	{
		//line 59 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
		boolean __temp_binary1 = ( (haxe.lang.Runtime.eq(binary, null)) ? (true) : (haxe.lang.Runtime.toBool(binary)) );
		//line 61 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
		try 
		{
			//line 61 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
			return new sys.io.FileInput(((java.io.RandomAccessFile) (new java.io.RandomAccessFile(((java.io.File) (new java.io.File(haxe.lang.Runtime.toString(path))) ), haxe.lang.Runtime.toString("r"))) ));
		}
		catch (java.lang.Throwable __temp_catchallException1)
		{
			//line 61 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
			haxe.lang.Exceptions.setException(__temp_catchallException1);
			//line 65 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
			java.lang.Object __temp_catchall2 = __temp_catchallException1;
			//line 65 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
			if (( __temp_catchall2 instanceof haxe.lang.HaxeException )) 
			{
				//line 65 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
				__temp_catchall2 = ((haxe.lang.HaxeException) (__temp_catchallException1) ).obj;
			}
			
			//line 65 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
			{
				//line 65 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
				java.lang.Object e = __temp_catchall2;
				//line 65 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
				throw haxe.lang.HaxeException.wrap(e);
			}
			
		}
		
		
	}
	
	
	public static sys.io.FileOutput write(java.lang.String path, java.lang.Object binary)
	{
		//line 70 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
		boolean __temp_binary2 = ( (haxe.lang.Runtime.eq(binary, null)) ? (true) : (haxe.lang.Runtime.toBool(binary)) );
		//line 71 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
		java.io.File f = new java.io.File(haxe.lang.Runtime.toString(path));
		//line 72 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
		if (f.exists()) 
		{
			//line 74 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
			f.delete();
		}
		
		//line 79 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
		try 
		{
			//line 79 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
			return new sys.io.FileOutput(((java.io.RandomAccessFile) (new java.io.RandomAccessFile(((java.io.File) (f) ), haxe.lang.Runtime.toString("rw"))) ));
		}
		catch (java.lang.Throwable __temp_catchallException1)
		{
			//line 79 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
			haxe.lang.Exceptions.setException(__temp_catchallException1);
			//line 83 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
			java.lang.Object __temp_catchall2 = __temp_catchallException1;
			//line 83 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
			if (( __temp_catchall2 instanceof haxe.lang.HaxeException )) 
			{
				//line 83 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
				__temp_catchall2 = ((haxe.lang.HaxeException) (__temp_catchallException1) ).obj;
			}
			
			//line 83 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
			{
				//line 83 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
				java.lang.Object e = __temp_catchall2;
				//line 83 "C:\\HaxeToolkit\\haxe\\std\\java\\_std\\sys\\io\\File.hx"
				throw haxe.lang.HaxeException.wrap(e);
			}
			
		}
		
		
	}
	
	
}



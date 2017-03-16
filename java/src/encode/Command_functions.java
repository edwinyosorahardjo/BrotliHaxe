// Generated by Haxe 3.4.0
package encode;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Command_functions extends haxe.lang.HxObject
{
	static
	{
		//line 27 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		encode.Command_functions.insbase = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{0, 1, 2, 3, 4, 5, 6, 8, 10, 14, 18, 26, 34, 50, 66, 98, 130, 194, 322, 578, 1090, 2114, 6210, 22594});
		//line 29 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		encode.Command_functions.insextra = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 12, 14, 24});
		//line 31 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		encode.Command_functions.copybase = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 18, 22, 30, 38, 54, 70, 102, 134, 198, 326, 582, 1094, 2118});
		//line 33 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		encode.Command_functions.copyextra = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 24});
	}
	
	public Command_functions(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Command_functions()
	{
		//line 107 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		encode.Command_functions.__hx_ctor_encode_Command_functions(this);
	}
	
	
	public static void __hx_ctor_encode_Command_functions(encode.Command_functions __hx_this)
	{
	}
	
	
	public static void GetDistCode(int distance_code, haxe.root.Array<java.lang.Object> code, haxe.root.Array<java.lang.Object> extra)
	{
		//line 15 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		if (( distance_code < 16 )) 
		{
			//line 16 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			code.__set(0, distance_code);
			//line 17 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			extra.__set(0, 0);
		}
		else
		{
			//line 19 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			distance_code -= 12;
			//line 20 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			int numextra = ( encode.Fast_log.Log2FloorNonZero(distance_code) - 1 );
			//line 21 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			int prefix = ( distance_code >> numextra );
			//line 22 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			code.__set(0, ( ( 12 + ( 2 * numextra ) ) + prefix ));
			//line 23 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			extra.__set(0, ( ( numextra << 24 ) | ( distance_code - (( prefix << numextra )) ) ));
		}
		
	}
	
	
	public static haxe.root.Array<java.lang.Object> insbase;
	
	public static haxe.root.Array<java.lang.Object> insextra;
	
	public static haxe.root.Array<java.lang.Object> copybase;
	
	public static haxe.root.Array<java.lang.Object> copyextra;
	
	public static int GetInsertLengthCode(int insertlen)
	{
		//line 37 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		if (( insertlen < 6 )) 
		{
			//line 38 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			return insertlen;
		}
		else
		{
			//line 39 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			if (( insertlen < 130 )) 
			{
				//line 40 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				insertlen -= 2;
				//line 41 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				int nbits = ( encode.Fast_log.Log2FloorNonZero(insertlen) - 1 );
				//line 42 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				return ( ( (( nbits << 1 )) + (( insertlen >> nbits )) ) + 2 );
			}
			else
			{
				//line 43 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				if (( insertlen < 2114 )) 
				{
					//line 44 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
					return ( encode.Fast_log.Log2FloorNonZero(( insertlen - 66 )) + 10 );
				}
				else
				{
					//line 45 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
					if (( insertlen < 6210 )) 
					{
						//line 46 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
						return 21;
					}
					else
					{
						//line 47 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
						if (( insertlen < 22594 )) 
						{
							//line 48 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
							return 22;
						}
						else
						{
							//line 50 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
							return 23;
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
	
	public static int GetCopyLengthCode(int copylen)
	{
		//line 56 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		if (( copylen < 10 )) 
		{
			//line 57 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			return ( copylen - 2 );
		}
		else
		{
			//line 58 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			if (( copylen < 134 )) 
			{
				//line 59 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				copylen -= 6;
				//line 60 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				int nbits = ( encode.Fast_log.Log2FloorNonZero(copylen) - 1 );
				//line 61 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				return ( ( (( nbits << 1 )) + (( copylen >> nbits )) ) + 4 );
			}
			else
			{
				//line 62 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				if (( copylen < 2118 )) 
				{
					//line 63 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
					return ( encode.Fast_log.Log2FloorNonZero(( copylen - 70 )) + 12 );
				}
				else
				{
					//line 65 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
					return 23;
				}
				
			}
			
		}
		
	}
	
	
	public static int CombineLengthCodes(int inscode, int copycode, int distancecode)
	{
		//line 72 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		int bits64 = ( ( copycode & 7 ) | ( (( inscode & 7 )) << 3 ) );
		//line 73 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		if (( ( ( distancecode == 0 ) && ( inscode < 8 ) ) && ( copycode < 16 ) )) 
		{
			//line 74 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			if (( copycode < 8 )) 
			{
				//line 74 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				return bits64;
			}
			else
			{
				//line 74 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				return ( bits64 | 64 );
			}
			
		}
		else
		{
			//line 78 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			haxe.root.Array<java.lang.Object> cells = new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{2, 3, 6, 4, 5, 8, 7, 9, 10});
			//line 79 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			return ( ( ((int) (haxe.lang.Runtime.toInt(cells.__get(( (( copycode >> 3 )) + ( 3 * (( inscode >> 3 )) ) )))) ) << 6 ) | bits64 );
		}
		
	}
	
	
	public static void GetLengthCode(int insertlen, int copylen, int distancecode, haxe.root.Array<java.lang.Object> code, haxe.root.Array<java.lang.Object> extra)
	{
		//line 86 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		int inscode = encode.Command_functions.GetInsertLengthCode(insertlen);
		//line 87 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		int copycode = encode.Command_functions.GetCopyLengthCode(copylen);
		//line 88 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		int insnumextra = ((int) (haxe.lang.Runtime.toInt(encode.Command_functions.insextra.__get(inscode))) );
		//line 89 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		int numextra = ( ((int) (insnumextra) ) + ((int) (haxe.lang.Runtime.toInt(encode.Command_functions.copyextra.__get(copycode))) ) );
		//line 90 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		int insextraval = ( insertlen - ((int) (haxe.lang.Runtime.toInt(encode.Command_functions.insbase.__get(inscode))) ) );
		//line 91 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		int copyextraval = ( copylen - ((int) (haxe.lang.Runtime.toInt(encode.Command_functions.copybase.__get(copycode))) ) );
		//line 92 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		code.__set(0, encode.Command_functions.CombineLengthCodes(inscode, copycode, distancecode));
		//line 93 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		boolean bNeg = ( ((int) (numextra) ) < 0 );
		//line 93 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
		if (( (( false != bNeg )) ? (false) : (( ((int) (32) ) > ((int) (numextra) ) )) )) 
		{
			//line 94 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			extra.__set(0, ((int) (( ((int) (( ((int) (numextra) ) << 16 )) ) | ((int) (0) ) )) ));
			//line 95 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			extra.__set(1, ((int) (( ((int) (( ((int) (copyextraval) ) << insnumextra )) ) | ((int) (insextraval) ) )) ));
		}
		else
		{
			//line 97 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			long value = ((long) (0) );
			//line 98 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			int _int = ((int) (numextra) );
			//line 98 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			value = ((long) (( ((long) (value) ) + (((long) (( (((long) (( (( _int < 0 )) ? (( 4294967296.0 + _int )) : (( _int + 0.0 )) )) )) << 48 )) )) )) );
			//line 99 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			int int1 = ((int) (copyextraval) );
			//line 99 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			value = ((long) (( ((long) (value) ) + (((long) (( (((long) (( (( int1 < 0 )) ? (( 4294967296.0 + int1 )) : (( int1 + 0.0 )) )) )) << insnumextra )) )) )) );
			//line 100 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			int int2 = ((int) (insextraval) );
			//line 100 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			value = ((long) (( ((long) (value) ) + (((long) (( (( int2 < 0 )) ? (( 4294967296.0 + int2 )) : (( int2 + 0.0 )) )) )) )) );
			//line 101 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			long x = ((long) (((int) (((long) (( ((long) (value) ) >> 32 )) )) )) );
			//line 101 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			if (( ((boolean) (( ((long) (x) ) < -2147483648 )) ) || ((boolean) (( ((long) (x) ) > 2147483647 )) ) )) 
			{
				//line 101 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				throw haxe.lang.HaxeException.wrap("Overflow");
			}
			
			//line 101 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			extra.__set(0, ((int) (((long) (x) )) ));
			//line 102 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			long x1 = ((long) (((int) (((long) (value) )) )) );
			//line 102 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			if (( ((boolean) (( ((long) (x1) ) < -2147483648 )) ) || ((boolean) (( ((long) (x1) ) > 2147483647 )) ) )) 
			{
				//line 102 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
				throw haxe.lang.HaxeException.wrap("Overflow");
			}
			
			//line 102 "C:\\Users\\Dominik\\Brotli\\src\\encode\\Command_functions.hx"
			extra.__set(1, ((int) (((long) (x1) )) ));
		}
		
	}
	
	
}



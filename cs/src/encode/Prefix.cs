// Generated by Haxe 3.4.0

#pragma warning disable 109, 114, 219, 429, 168, 162
namespace encode {
	public class Prefix : global::haxe.lang.HxObject {
		
		static Prefix() {
			unchecked {
				global::encode.Prefix.kNumInsertLenPrefixes = 24;
				global::encode.Prefix.kNumCopyLenPrefixes = 24;
				global::encode.Prefix.kNumCommandPrefixes = 704;
				global::encode.Prefix.kNumBlockLenPrefixes = 26;
				global::encode.Prefix.kNumDistanceShortCodes = 16;
				global::encode.Prefix.kNumDistancePrefixes = 520;
				global::encode.Prefix.kBlockLengthPrefixCode = new global::Array<object>(new object[]{new global::encode.prefix.PrefixCodeRange(1, 2), new global::encode.prefix.PrefixCodeRange(5, 2), new global::encode.prefix.PrefixCodeRange(9, 2), new global::encode.prefix.PrefixCodeRange(13, 2), new global::encode.prefix.PrefixCodeRange(17, 3), new global::encode.prefix.PrefixCodeRange(25, 3), new global::encode.prefix.PrefixCodeRange(33, 3), new global::encode.prefix.PrefixCodeRange(41, 3), new global::encode.prefix.PrefixCodeRange(49, 4), new global::encode.prefix.PrefixCodeRange(65, 4), new global::encode.prefix.PrefixCodeRange(81, 4), new global::encode.prefix.PrefixCodeRange(97, 4), new global::encode.prefix.PrefixCodeRange(113, 5), new global::encode.prefix.PrefixCodeRange(145, 5), new global::encode.prefix.PrefixCodeRange(177, 5), new global::encode.prefix.PrefixCodeRange(209, 5), new global::encode.prefix.PrefixCodeRange(241, 6), new global::encode.prefix.PrefixCodeRange(305, 6), new global::encode.prefix.PrefixCodeRange(369, 7), new global::encode.prefix.PrefixCodeRange(497, 8), new global::encode.prefix.PrefixCodeRange(753, 9), new global::encode.prefix.PrefixCodeRange(1265, 10), new global::encode.prefix.PrefixCodeRange(2289, 11), new global::encode.prefix.PrefixCodeRange(4337, 12), new global::encode.prefix.PrefixCodeRange(8433, 13), new global::encode.prefix.PrefixCodeRange(16625, 24)});
			}
		}
		
		
		public Prefix(global::haxe.lang.EmptyObject empty) {
		}
		
		
		public Prefix() {
			global::encode.Prefix.__hx_ctor_encode_Prefix(this);
		}
		
		
		public static void __hx_ctor_encode_Prefix(global::encode.Prefix __hx_this) {
		}
		
		
		public static int kNumInsertLenPrefixes;
		
		public static int kNumCopyLenPrefixes;
		
		public static int kNumCommandPrefixes;
		
		public static int kNumBlockLenPrefixes;
		
		public static int kNumDistanceShortCodes;
		
		public static int kNumDistancePrefixes;
		
		public static global::Array<object> kBlockLengthPrefixCode;
		
		public static void GetBlockLengthPrefixCode(int len, int[] code, int code_off, int[] n_extra, int n_extra_off, int[] extra, int extra_off) {
			unchecked {
				((int[]) (code) )[code_off] = 0;
				while (( ( ((int) (((int[]) (code) )[code_off]) ) < 25 ) && ( len >= ((global::encode.prefix.PrefixCodeRange) (global::encode.Prefix.kBlockLengthPrefixCode[( ((int) (((int[]) (code) )[code_off]) ) + 1 )]) ).offset ) )) {
					((int[]) (code) )[code_off] = ( ((int) (((int[]) (code) )[code_off]) ) + 1 );
				}
				
				((int[]) (n_extra) )[n_extra_off] = ((global::encode.prefix.PrefixCodeRange) (global::encode.Prefix.kBlockLengthPrefixCode[((int) (((int[]) (code) )[code_off]) )]) ).nbits;
				((int[]) (extra) )[extra_off] = ( len - ((global::encode.prefix.PrefixCodeRange) (global::encode.Prefix.kBlockLengthPrefixCode[((int) (((int[]) (code) )[code_off]) )]) ).offset );
			}
		}
		
		
		public static void PrefixEncodeCopyDistance(int distance_code, int num_direct_codes, int postfix_bits, global::Array<uint> code, global::Array<uint> extra_bits) {
			unchecked {
				if (( distance_code < ( 16 + num_direct_codes ) )) {
					code[0] = ((uint) (distance_code) );
					extra_bits[0] = ((uint) (0) );
					return;
				}
				
				distance_code -= ( 16 + num_direct_codes );
				distance_code += ( 1 << ( postfix_bits + 2 ) );
				int bucket = ( global::encode.Fast_log.Log2Floor(((uint) (distance_code) )) - 1 );
				int prefix = ( ( distance_code >> bucket ) & 1 );
				int nbits = ( bucket - postfix_bits );
				code[0] = ((uint) (( ( ( 16 + num_direct_codes ) + (( ( ( 2 * (( nbits - 1 )) ) + prefix ) << postfix_bits )) ) + (( distance_code & ( (( 1 << postfix_bits )) - 1 ) )) )) );
				extra_bits[0] = ((uint) (( ( nbits << 24 ) | ( ( distance_code - (( ( 2 + prefix ) << bucket )) ) >> postfix_bits ) )) );
			}
		}
		
		
	}
}



// Generated by Haxe 3.4.0

#pragma warning disable 109, 114, 219, 429, 168, 162
namespace encode.streams {
	public class BrotliOut : global::haxe.lang.HxObject {
		
		public BrotliOut(global::haxe.lang.EmptyObject empty) {
		}
		
		
		public BrotliOut(global::sys.io.FileOutput f) {
			global::encode.streams.BrotliOut.__hx_ctor_encode_streams_BrotliOut(this, f);
		}
		
		
		public static void __hx_ctor_encode_streams_BrotliOut(global::encode.streams.BrotliOut __hx_this, global::sys.io.FileOutput f) {
			__hx_this.f_ = f;
		}
		
		
		public global::sys.io.FileOutput f_;
		
		public virtual bool Write(int[] buf, int n) {
			global::haxe.io.Bytes bytes = global::haxe.io.Bytes.alloc(n);
			{
				int _g1 = 0;
				while (( _g1 < n )) {
					int i = _g1++;
					bytes.b[i] = ((byte) (((int) (((int[]) (buf) )[i]) )) );
				}
				
			}
			
			this.f_.write(bytes);
			return true;
		}
		
		
		public override object __hx_setField(string field, int hash, object @value, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 22841:
					{
						this.f_ = ((global::sys.io.FileOutput) (@value) );
						return @value;
					}
					
					
					default:
					{
						return base.__hx_setField(field, hash, @value, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override object __hx_getField(string field, int hash, bool throwErrors, bool isCheck, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 1669782719:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "Write", 1669782719)) );
					}
					
					
					case 22841:
					{
						return this.f_;
					}
					
					
					default:
					{
						return base.__hx_getField(field, hash, throwErrors, isCheck, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override object __hx_invokeField(string field, int hash, global::Array dynargs) {
			unchecked {
				switch (hash) {
					case 1669782719:
					{
						return this.Write(((int[]) (dynargs[0]) ), ((int) (global::haxe.lang.Runtime.toInt(dynargs[1])) ));
					}
					
					
					default:
					{
						return base.__hx_invokeField(field, hash, dynargs);
					}
					
				}
				
			}
		}
		
		
		public override void __hx_getFields(global::Array<object> baseArr) {
			baseArr.push("f_");
			base.__hx_getFields(baseArr);
		}
		
		
	}
}



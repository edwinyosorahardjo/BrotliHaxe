// Generated by Haxe 3.4.0

#pragma warning disable 109, 114, 219, 429, 168, 162
namespace encode.metablock {
	public class MetaBlockSplit : global::haxe.lang.HxObject {
		
		public MetaBlockSplit(global::haxe.lang.EmptyObject empty) {
		}
		
		
		public MetaBlockSplit() {
			global::encode.metablock.MetaBlockSplit.__hx_ctor_encode_metablock_MetaBlockSplit(this);
		}
		
		
		public static void __hx_ctor_encode_metablock_MetaBlockSplit(global::encode.metablock.MetaBlockSplit __hx_this) {
			__hx_this.distance_histograms = new global::Array<object>();
			__hx_this.command_histograms = new global::Array<object>();
			__hx_this.literal_histograms = new global::Array<object>();
			{
				int[] this1 = null;
				this1 = new int[0];
				__hx_this.distance_context_map = ((int[]) (this1) );
			}
			
			{
				int[] this1 = null;
				this1 = new int[0];
				__hx_this.literal_context_map = ((int[]) (this1) );
			}
			
			__hx_this.distance_split = new global::encode.metablock.BlockSplit();
			__hx_this.command_split = new global::encode.metablock.BlockSplit();
			__hx_this.literal_split = new global::encode.metablock.BlockSplit();
		}
		
		
		public global::encode.metablock.BlockSplit literal_split;
		
		public global::encode.metablock.BlockSplit command_split;
		
		public global::encode.metablock.BlockSplit distance_split;
		
		public int[] literal_context_map;
		
		public int[] distance_context_map;
		
		public global::Array<object> literal_histograms;
		
		public global::Array<object> command_histograms;
		
		public global::Array<object> distance_histograms;
		
		public override object __hx_setField(string field, int hash, object @value, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 401849689:
					{
						this.distance_histograms = ((global::Array<object>) (global::Array<object>.__hx_cast<object>(((global::Array) (@value) ))) );
						return @value;
					}
					
					
					case 149162755:
					{
						this.command_histograms = ((global::Array<object>) (global::Array<object>.__hx_cast<object>(((global::Array) (@value) ))) );
						return @value;
					}
					
					
					case 1474051423:
					{
						this.literal_histograms = ((global::Array<object>) (global::Array<object>.__hx_cast<object>(((global::Array) (@value) ))) );
						return @value;
					}
					
					
					case 230081986:
					{
						this.distance_context_map = ((int[]) (@value) );
						return @value;
					}
					
					
					case 960383740:
					{
						this.literal_context_map = ((int[]) (@value) );
						return @value;
					}
					
					
					case 422681360:
					{
						this.distance_split = ((global::encode.metablock.BlockSplit) (@value) );
						return @value;
					}
					
					
					case 1991781798:
					{
						this.command_split = ((global::encode.metablock.BlockSplit) (@value) );
						return @value;
					}
					
					
					case 1256528074:
					{
						this.literal_split = ((global::encode.metablock.BlockSplit) (@value) );
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
					case 401849689:
					{
						return this.distance_histograms;
					}
					
					
					case 149162755:
					{
						return this.command_histograms;
					}
					
					
					case 1474051423:
					{
						return this.literal_histograms;
					}
					
					
					case 230081986:
					{
						return this.distance_context_map;
					}
					
					
					case 960383740:
					{
						return this.literal_context_map;
					}
					
					
					case 422681360:
					{
						return this.distance_split;
					}
					
					
					case 1991781798:
					{
						return this.command_split;
					}
					
					
					case 1256528074:
					{
						return this.literal_split;
					}
					
					
					default:
					{
						return base.__hx_getField(field, hash, throwErrors, isCheck, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override void __hx_getFields(global::Array<object> baseArr) {
			baseArr.push("distance_histograms");
			baseArr.push("command_histograms");
			baseArr.push("literal_histograms");
			baseArr.push("distance_context_map");
			baseArr.push("literal_context_map");
			baseArr.push("distance_split");
			baseArr.push("command_split");
			baseArr.push("literal_split");
			base.__hx_getFields(baseArr);
		}
		
		
	}
}



// Generated by Haxe 3.4.0

#pragma warning disable 109, 114, 219, 429, 168, 162
namespace haxe.ds {
	public class IntMap<T> : global::haxe.lang.HxObject, global::haxe.ds.IntMap, global::haxe.IMap<int, T> {
		
		public IntMap(global::haxe.lang.EmptyObject empty) {
		}
		
		
		public IntMap() {
			global::haxe.ds.IntMap<object>.__hx_ctor_haxe_ds_IntMap<T>(((global::haxe.ds.IntMap<T>) (this) ));
		}
		
		
		public static void __hx_ctor_haxe_ds_IntMap<T_c>(global::haxe.ds.IntMap<T_c> __hx_this) {
			unchecked {
				__hx_this.cachedIndex = -1;
			}
		}
		
		
		public static object __hx_cast<T_c_c>(global::haxe.ds.IntMap me) {
			return ( (( me != null )) ? (me.haxe_ds_IntMap_cast<T_c_c>()) : default(object) );
		}
		
		
		public virtual object haxe_ds_IntMap_cast<T_c>() {
			unchecked {
				if (global::haxe.lang.Runtime.eq(typeof(T), typeof(T_c))) {
					return this;
				}
				
				global::haxe.ds.IntMap<T_c> new_me = new global::haxe.ds.IntMap<T_c>(global::haxe.lang.EmptyObject.EMPTY);
				global::Array<object> fields = global::Reflect.fields(this);
				int i = 0;
				while (( i < fields.length )) {
					string field = global::haxe.lang.Runtime.toString(fields[i++]);
					switch (field) {
						case "vals":
						{
							if (( this.vals != null )) {
								T_c[] __temp_new_arr4 = new T_c[this.vals.Length];
								int __temp_i5 = -1;
								while ((  ++ __temp_i5 < this.vals.Length )) {
									object __temp_obj6 = ((object) (this.vals[__temp_i5]) );
									if (( __temp_obj6 != null )) {
										__temp_new_arr4[__temp_i5] = global::haxe.lang.Runtime.genericCast<T_c>(__temp_obj6);
									}
									
								}
								
								new_me.vals = __temp_new_arr4;
							}
							else {
								new_me.vals = null;
							}
							
							break;
						}
						
						
						default:
						{
							global::Reflect.setField(new_me, field, global::Reflect.field(this, field));
							break;
						}
						
					}
					
				}
				
				return new_me;
			}
		}
		
		
		public virtual object haxe_IMap_cast<K_c, V_c>() {
			return this.haxe_ds_IntMap_cast<V_c>();
		}
		
		
		public int[] flags;
		
		public int[] _keys;
		
		public T[] vals;
		
		public int nBuckets;
		
		public int size;
		
		public int nOccupied;
		
		public int upperBound;
		
		public int cachedKey;
		
		public int cachedIndex;
		
		public virtual void @set(int key, T @value) {
			unchecked {
				int x = default(int);
				if (( this.nOccupied >= this.upperBound )) {
					if (( this.nBuckets > ( this.size << 1 ) )) {
						this.resize(( this.nBuckets - 1 ));
					}
					else {
						this.resize(( this.nBuckets + 1 ));
					}
					
				}
				
				int[] flags = this.flags;
				int[] _keys = this._keys;
				{
					int mask = ( this.nBuckets - 1 );
					x = this.nBuckets;
					int i = ( key & mask );
					int delKey = -1;
					if (( (( ((int) (( ((uint) (flags[( i >> 4 )]) ) >> (( (( i & 15 )) << 1 )) )) ) & 2 )) != 0 )) {
						x = i;
					}
					else {
						int inc = ( (( ( ( key >> 3 ) ^ ( key << 3 ) ) | 1 )) & mask );
						while ( ! ((( ( (( ((int) (( ((uint) (flags[( i >> 4 )]) ) >> (( (( i & 15 )) << 1 )) )) ) & 2 )) != 0 ) || ( _keys[i] == key ) ))) ) {
							if (( ( delKey == -1 ) && ( (( ((int) (( ((uint) (flags[( i >> 4 )]) ) >> (( (( i & 15 )) << 1 )) )) ) & 1 )) != 0 ) )) {
								delKey = i;
							}
							
							i = ( ( i + inc ) & mask );
						}
						
						if (( ( (( ((int) (( ((uint) (flags[( i >> 4 )]) ) >> (( (( i & 15 )) << 1 )) )) ) & 2 )) != 0 ) && ( delKey != -1 ) )) {
							x = delKey;
						}
						else {
							x = i;
						}
						
					}
					
				}
				
				if (( (( ((int) (( ((uint) (flags[( x >> 4 )]) ) >> (( (( x & 15 )) << 1 )) )) ) & 2 )) != 0 )) {
					_keys[x] = key;
					this.vals[x] = @value;
					flags[( x >> 4 )] &=  ~ ((( 3 << (( (( x & 15 )) << 1 )) ))) ;
					this.size++;
					this.nOccupied++;
				}
				else if (( (( ((int) (( ((uint) (flags[( x >> 4 )]) ) >> (( (( x & 15 )) << 1 )) )) ) & 1 )) != 0 )) {
					_keys[x] = key;
					this.vals[x] = @value;
					flags[( x >> 4 )] &=  ~ ((( 3 << (( (( x & 15 )) << 1 )) ))) ;
					this.size++;
				}
				else {
					this.vals[x] = @value;
				}
				
			}
		}
		
		
		public int lookup(int key) {
			unchecked {
				if (( this.nBuckets != 0 )) {
					int[] flags = this.flags;
					int[] _keys = this._keys;
					int mask = ( this.nBuckets - 1 );
					int i = ( key & mask );
					int inc = ( (( ( ( key >> 3 ) ^ ( key << 3 ) ) | 1 )) & mask );
					int last = i;
					while (( ( (( ((int) (( ((uint) (flags[( i >> 4 )]) ) >> (( (( i & 15 )) << 1 )) )) ) & 2 )) == 0 ) && (( ( (( ((int) (( ((uint) (flags[( i >> 4 )]) ) >> (( (( i & 15 )) << 1 )) )) ) & 1 )) != 0 ) || ( _keys[i] != key ) )) )) {
						i = ( ( i + inc ) & mask );
						if (( i == last )) {
							return -1;
						}
						
					}
					
					if (( (( ((int) (( ((uint) (flags[( i >> 4 )]) ) >> (( (( i & 15 )) << 1 )) )) ) & 3 )) != 0 )) {
						return -1;
					}
					else {
						return i;
					}
					
				}
				
				return -1;
			}
		}
		
		
		public virtual global::haxe.lang.Null<T> @get(int key) {
			unchecked {
				int idx = -1;
				bool tmp = default(bool);
				if (( this.cachedKey == key )) {
					idx = this.cachedIndex;
					tmp = ( idx != -1 );
				}
				else {
					tmp = false;
				}
				
				if (tmp) {
					return new global::haxe.lang.Null<T>(this.vals[idx], true);
				}
				
				idx = this.lookup(key);
				if (( idx != -1 )) {
					this.cachedKey = key;
					this.cachedIndex = idx;
					return new global::haxe.lang.Null<T>(this.vals[idx], true);
				}
				
				return default(global::haxe.lang.Null<T>);
			}
		}
		
		
		public virtual bool exists(int key) {
			unchecked {
				int idx = -1;
				bool tmp = default(bool);
				if (( this.cachedKey == key )) {
					idx = this.cachedIndex;
					tmp = ( idx != -1 );
				}
				else {
					tmp = false;
				}
				
				if (tmp) {
					return true;
				}
				
				idx = this.lookup(key);
				if (( idx != -1 )) {
					this.cachedKey = key;
					this.cachedIndex = idx;
					return true;
				}
				
				return false;
			}
		}
		
		
		public void resize(int newNBuckets) {
			unchecked {
				int[] newFlags = null;
				int j = 1;
				{
					int x = newNBuckets;
					 -- x;
					x |= ((int) (( ((uint) (x) ) >> 1 )) );
					x |= ((int) (( ((uint) (x) ) >> 2 )) );
					x |= ((int) (( ((uint) (x) ) >> 4 )) );
					x |= ((int) (( ((uint) (x) ) >> 8 )) );
					x |= ((int) (( ((uint) (x) ) >> 16 )) );
					newNBuckets =  ++ x;
					if (( newNBuckets < 4 )) {
						newNBuckets = 4;
					}
					
					if (( this.size >= ( ( newNBuckets * 0.7 ) + 0.5 ) )) {
						j = 0;
					}
					else {
						int nfSize = ( (( newNBuckets < 16 )) ? (1) : (( newNBuckets >> 4 )) );
						newFlags = new int[nfSize];
						{
							int _g1 = 0;
							int _g = nfSize;
							while (( _g1 < _g )) {
								newFlags[_g1++] = -1431655766;
							}
							
						}
						
						if (( this.nBuckets < newNBuckets )) {
							int[] k = new int[newNBuckets];
							if (( this._keys != null )) {
								global::System.Array.Copy(((global::System.Array) (this._keys) ), ((int) (0) ), ((global::System.Array) (k) ), ((int) (0) ), ((int) (this.nBuckets) ));
							}
							
							this._keys = k;
							T[] v = new T[newNBuckets];
							if (( this.vals != null )) {
								global::System.Array.Copy(((global::System.Array) (this.vals) ), ((int) (0) ), ((global::System.Array) (v) ), ((int) (0) ), ((int) (this.nBuckets) ));
							}
							
							this.vals = v;
						}
						
					}
					
				}
				
				if (( j != 0 )) {
					this.cachedKey = 0;
					this.cachedIndex = -1;
					j = -1;
					int nBuckets = this.nBuckets;
					int[] _keys = this._keys;
					T[] vals = this.vals;
					int[] flags = this.flags;
					int newMask = ( newNBuckets - 1 );
					while ((  ++ j < nBuckets )) {
						if (( (( ((int) (( ((uint) (flags[( j >> 4 )]) ) >> (( (( j & 15 )) << 1 )) )) ) & 3 )) == 0 )) {
							int key = _keys[j];
							T val = vals[j];
							flags[( j >> 4 )] |= ( 1 << (( (( j & 15 )) << 1 )) );
							while (true) {
								int k1 = key;
								int inc = ( (( ( ( k1 >> 3 ) ^ ( k1 << 3 ) ) | 1 )) & newMask );
								int i = ( k1 & newMask );
								while (( (( ((int) (( ((uint) (newFlags[( i >> 4 )]) ) >> (( (( i & 15 )) << 1 )) )) ) & 2 )) == 0 )) {
									i = ( ( i + inc ) & newMask );
								}
								
								newFlags[( i >> 4 )] &=  ~ ((( 2 << (( (( i & 15 )) << 1 )) ))) ;
								if (( ( i < nBuckets ) && ( (( ((int) (( ((uint) (flags[( i >> 4 )]) ) >> (( (( i & 15 )) << 1 )) )) ) & 3 )) == 0 ) )) {
									{
										int tmp = _keys[i];
										_keys[i] = key;
										key = tmp;
									}
									
									{
										T tmp1 = vals[i];
										vals[i] = val;
										val = tmp1;
									}
									
									flags[( i >> 4 )] |= ( 1 << (( (( i & 15 )) << 1 )) );
								}
								else {
									_keys[i] = key;
									vals[i] = val;
									break;
								}
								
							}
							
						}
						
					}
					
					if (( nBuckets > newNBuckets )) {
						{
							int[] k2 = new int[newNBuckets];
							global::System.Array.Copy(((global::System.Array) (_keys) ), ((int) (0) ), ((global::System.Array) (k2) ), ((int) (0) ), ((int) (newNBuckets) ));
							this._keys = k2;
						}
						
						{
							T[] v1 = new T[newNBuckets];
							global::System.Array.Copy(((global::System.Array) (vals) ), ((int) (0) ), ((global::System.Array) (v1) ), ((int) (0) ), ((int) (newNBuckets) ));
							this.vals = v1;
						}
						
					}
					
					this.flags = newFlags;
					this.nBuckets = newNBuckets;
					this.nOccupied = this.size;
					this.upperBound = ((int) (( ( newNBuckets * 0.7 ) + .5 )) );
				}
				
			}
		}
		
		
		public override double __hx_setField_f(string field, int hash, double @value, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 922671056:
					{
						this.cachedIndex = ((int) (@value) );
						return @value;
					}
					
					
					case 1395555037:
					{
						this.cachedKey = ((int) (@value) );
						return @value;
					}
					
					
					case 2022294396:
					{
						this.upperBound = ((int) (@value) );
						return @value;
					}
					
					
					case 480756972:
					{
						this.nOccupied = ((int) (@value) );
						return @value;
					}
					
					
					case 1280549057:
					{
						this.size = ((int) (@value) );
						return @value;
					}
					
					
					case 1537812987:
					{
						this.nBuckets = ((int) (@value) );
						return @value;
					}
					
					
					default:
					{
						return base.__hx_setField_f(field, hash, @value, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override object __hx_setField(string field, int hash, object @value, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 922671056:
					{
						this.cachedIndex = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 1395555037:
					{
						this.cachedKey = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 2022294396:
					{
						this.upperBound = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 480756972:
					{
						this.nOccupied = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 1280549057:
					{
						this.size = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 1537812987:
					{
						this.nBuckets = ((int) (global::haxe.lang.Runtime.toInt(@value)) );
						return @value;
					}
					
					
					case 1313416818:
					{
						this.vals = ((T[]) (@value) );
						return @value;
					}
					
					
					case 2048392659:
					{
						this._keys = ((int[]) (@value) );
						return @value;
					}
					
					
					case 42740551:
					{
						this.flags = ((int[]) (@value) );
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
					case 142301684:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "resize", 142301684)) );
					}
					
					
					case 1071652316:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "exists", 1071652316)) );
					}
					
					
					case 5144726:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "get", 5144726)) );
					}
					
					
					case 1639293562:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "lookup", 1639293562)) );
					}
					
					
					case 5741474:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "set", 5741474)) );
					}
					
					
					case 922671056:
					{
						return this.cachedIndex;
					}
					
					
					case 1395555037:
					{
						return this.cachedKey;
					}
					
					
					case 2022294396:
					{
						return this.upperBound;
					}
					
					
					case 480756972:
					{
						return this.nOccupied;
					}
					
					
					case 1280549057:
					{
						return this.size;
					}
					
					
					case 1537812987:
					{
						return this.nBuckets;
					}
					
					
					case 1313416818:
					{
						return this.vals;
					}
					
					
					case 2048392659:
					{
						return this._keys;
					}
					
					
					case 42740551:
					{
						return this.flags;
					}
					
					
					default:
					{
						return base.__hx_getField(field, hash, throwErrors, isCheck, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override double __hx_getField_f(string field, int hash, bool throwErrors, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 922671056:
					{
						return ((double) (this.cachedIndex) );
					}
					
					
					case 1395555037:
					{
						return ((double) (this.cachedKey) );
					}
					
					
					case 2022294396:
					{
						return ((double) (this.upperBound) );
					}
					
					
					case 480756972:
					{
						return ((double) (this.nOccupied) );
					}
					
					
					case 1280549057:
					{
						return ((double) (this.size) );
					}
					
					
					case 1537812987:
					{
						return ((double) (this.nBuckets) );
					}
					
					
					default:
					{
						return base.__hx_getField_f(field, hash, throwErrors, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override object __hx_invokeField(string field, int hash, global::Array dynargs) {
			unchecked {
				switch (hash) {
					case 142301684:
					{
						this.resize(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ));
						break;
					}
					
					
					case 1071652316:
					{
						return this.exists(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ));
					}
					
					
					case 5144726:
					{
						return (this.@get(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ))).toDynamic();
					}
					
					
					case 1639293562:
					{
						return this.lookup(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ));
					}
					
					
					case 5741474:
					{
						this.@set(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ), global::haxe.lang.Runtime.genericCast<T>(dynargs[1]));
						break;
					}
					
					
					default:
					{
						return base.__hx_invokeField(field, hash, dynargs);
					}
					
				}
				
				return null;
			}
		}
		
		
		public override void __hx_getFields(global::Array<object> baseArr) {
			baseArr.push("cachedIndex");
			baseArr.push("cachedKey");
			baseArr.push("upperBound");
			baseArr.push("nOccupied");
			baseArr.push("size");
			baseArr.push("nBuckets");
			baseArr.push("vals");
			baseArr.push("_keys");
			baseArr.push("flags");
			base.__hx_getFields(baseArr);
		}
		
		
	}
}



#pragma warning disable 109, 114, 219, 429, 168, 162
namespace haxe.ds {
	[global::haxe.lang.GenericInterface(typeof(global::haxe.ds.IntMap<object>))]
	public interface IntMap : global::haxe.lang.IHxObject, global::haxe.lang.IGenericObject {
		
		object haxe_ds_IntMap_cast<T_c>();
		
		object haxe_IMap_cast<K_c, V_c>();
		
		int lookup(int key);
		
		bool exists(int key);
		
		void resize(int newNBuckets);
		
	}
}



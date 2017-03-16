<?php

// Generated by Haxe 3.4.0
class encode_Brotli_bit_stream {
	public function __construct() {}
	static function EncodeMlen($length, $bits, $numbits, $nibblesbits) {
		$length = $length - 1;
		$lg = null;
		if($length === 0) {
			$lg = 1;
		} else {
			$lg = encode_Fast_log::Log2Floor($length) + 1;
		}
		if($lg > 24) {
			return false;
		}
		$mnibbles = null;
		if($lg < 16) {
			$mnibbles = 16;
		} else {
			$mnibbles = $lg + 3;
		}
		$mnibbles1 = Std::int($mnibbles / 4);
		$nibblesbits[0] = $mnibbles1 - 4;
		$numbits[0] = $mnibbles1 * 4;
		$bits[0] = $length;
		return true;
	}
	static function StoreVarLenUint8($n, $storage_ix, $storage) {
		if($n === 0) {
			encode_Write_bits::WriteBits(1, 0, $storage_ix, $storage);
		} else {
			encode_Write_bits::WriteBits(1, 1, $storage_ix, $storage);
			$nbits = encode_Fast_log::Log2Floor($n);
			encode_Write_bits::WriteBits(3, $nbits, $storage_ix, $storage);
			encode_Write_bits::WriteBits($nbits, $n - (1 << $nbits), $storage_ix, $storage);
		}
	}
	static function StoreCompressedMetaBlockHeader($final_block, $length, $storage_ix, $storage) {
		$tmp = null;
		if($final_block) {
			$tmp = 1;
		} else {
			$tmp = 0;
		}
		encode_Write_bits::WriteBits(1, $tmp, $storage_ix, $storage);
		if($final_block) {
			$tmp1 = null;
			if($length === 0) {
				$tmp1 = 1;
			} else {
				$tmp1 = 0;
			}
			encode_Write_bits::WriteBits(1, $tmp1, $storage_ix, $storage);
			if($length === 0) {
				return true;
			}
		}
		if($length === 0) {
			return false;
		}
		$lenbits = new _hx_array(array());
		$nlenbits = new _hx_array(array());
		$nibblesbits = new _hx_array(array());
		if(!encode_Brotli_bit_stream::EncodeMlen($length, $lenbits, $nlenbits, $nibblesbits)) {
			return false;
		}
		encode_Write_bits::WriteBits(2, $nibblesbits[0], $storage_ix, $storage);
		encode_Write_bits::WriteBits($nlenbits[0], $lenbits[0], $storage_ix, $storage);
		if(!$final_block) {
			encode_Write_bits::WriteBits(1, 0, $storage_ix, $storage);
		}
		return true;
	}
	static function StoreUncompressedMetaBlockHeader($length, $storage_ix, $storage) {
		encode_Write_bits::WriteBits(1, 0, $storage_ix, $storage);
		$lenbits = new _hx_array(array());
		$nlenbits = new _hx_array(array());
		$nibblesbits = new _hx_array(array());
		if(!encode_Brotli_bit_stream::EncodeMlen($length, $lenbits, $nlenbits, $nibblesbits)) {
			return false;
		}
		encode_Write_bits::WriteBits(2, $nibblesbits[0], $storage_ix, $storage);
		encode_Write_bits::WriteBits($nlenbits[0], $lenbits[0], $storage_ix, $storage);
		encode_Write_bits::WriteBits(1, 1, $storage_ix, $storage);
		return true;
	}
	static function StoreHuffmanTreeOfHuffmanTreeToBitMask($num_codes, $code_length_bitdepth, $storage_ix, $storage) {
		$kStorageOrder = (new _hx_array(array(1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15)));
		$kHuffmanBitLengthHuffmanCodeSymbols = (new _hx_array(array(0, 7, 3, 2, 1, 15)));
		$kHuffmanBitLengthHuffmanCodeBitLengths = (new _hx_array(array(2, 4, 3, 2, 2, 4)));
		$codes_to_store = 18;
		if($num_codes > 1) {
			while($codes_to_store > 0) {
				if($code_length_bitdepth[$kStorageOrder[$codes_to_store - 1]] !== 0) {
					break;
				}
				$codes_to_store = $codes_to_store - 1;
			}
		}
		$skip_some = 0;
		$tmp = null;
		if($code_length_bitdepth[$kStorageOrder[0]] === 0) {
			$tmp = $code_length_bitdepth[$kStorageOrder[1]] === 0;
		} else {
			$tmp = false;
		}
		if($tmp) {
			$skip_some = 2;
			if($code_length_bitdepth[$kStorageOrder[2]] === 0) {
				$skip_some = 3;
			}
		}
		encode_Write_bits::WriteBits(2, $skip_some, $storage_ix, $storage);
		{
			$_g1 = $skip_some;
			$_g = $codes_to_store;
			while($_g1 < $_g) {
				$_g1 = $_g1 + 1;
				$l = $code_length_bitdepth[$kStorageOrder[$_g1 - 1]];
				encode_Write_bits::WriteBits($kHuffmanBitLengthHuffmanCodeBitLengths[$l], $kHuffmanBitLengthHuffmanCodeSymbols[$l], $storage_ix, $storage);
				unset($l);
			}
		}
	}
	static function StoreHuffmanTreeToBitMask($huffman_tree, $huffman_tree_extra_bits, $code_length_bitdepth, $code_length_bitdepth_off, $code_length_bitdepth_symbols, $storage_ix, $storage) {
		$_g1 = 0;
		$_g = $huffman_tree->length;
		while($_g1 < $_g) {
			$_g1 = $_g1 + 1;
			$i = $_g1 - 1;
			$ix = $huffman_tree[$i];
			encode_Write_bits::WriteBits($code_length_bitdepth[$ix], $code_length_bitdepth_symbols[$ix], $storage_ix, $storage);
			switch($ix) {
			case 16:{
				encode_Write_bits::WriteBits(2, $huffman_tree_extra_bits[$i], $storage_ix, $storage);
			}break;
			case 17:{
				encode_Write_bits::WriteBits(3, $huffman_tree_extra_bits[$i], $storage_ix, $storage);
			}break;
			}
			unset($ix,$i);
		}
	}
	static function StoreSimpleHuffmanTree($depths, $depths_off, $symbols, $num_symbols, $max_bits, $storage_ix, $storage) {
		encode_Write_bits::WriteBits(2, 1, $storage_ix, $storage);
		encode_Write_bits::WriteBits(2, $num_symbols - 1, $storage_ix, $storage);
		{
			$_g1 = 0;
			while($_g1 < $num_symbols) {
				$_g1 = $_g1 + 1;
				$i = $_g1 - 1;
				{
					$_g3 = $i + 1;
					while($_g3 < $num_symbols) {
						$_g3 = $_g3 + 1;
						$j = $_g3 - 1;
						$a = $depths[$depths_off + $symbols[$j]];
						$b = $depths[$depths_off + $symbols[$i]];
						$aNeg = $b < 0;
						$tmp = null;
						if($aNeg !== $a < 0) {
							$tmp = $aNeg;
						} else {
							$tmp = $b > $a;
						}
						if($tmp) {
							$t = $symbols[$j];
							$symbols[$j] = $symbols[$i];
							$symbols[$i] = $t;
							unset($t);
						}
						unset($tmp,$j,$b,$aNeg,$a);
					}
					unset($_g3);
				}
				unset($i);
			}
		}
		if($num_symbols === 2) {
			encode_Write_bits::WriteBits($max_bits, $symbols[0], $storage_ix, $storage);
			encode_Write_bits::WriteBits($max_bits, $symbols[1], $storage_ix, $storage);
		} else {
			if($num_symbols === 3) {
				encode_Write_bits::WriteBits($max_bits, $symbols[0], $storage_ix, $storage);
				encode_Write_bits::WriteBits($max_bits, $symbols[1], $storage_ix, $storage);
				encode_Write_bits::WriteBits($max_bits, $symbols[2], $storage_ix, $storage);
			} else {
				encode_Write_bits::WriteBits($max_bits, $symbols[0], $storage_ix, $storage);
				encode_Write_bits::WriteBits($max_bits, $symbols[1], $storage_ix, $storage);
				encode_Write_bits::WriteBits($max_bits, $symbols[2], $storage_ix, $storage);
				encode_Write_bits::WriteBits($max_bits, $symbols[3], $storage_ix, $storage);
				$tmp1 = null;
				if($depths[$depths_off + $symbols[0]] === 1) {
					$tmp1 = 1;
				} else {
					$tmp1 = 0;
				}
				encode_Write_bits::WriteBits(1, $tmp1, $storage_ix, $storage);
			}
		}
	}
	static function StoreHuffmanTree($depths, $depths_off, $num, $storage_ix, $storage) {
		$huffman_tree = new _hx_array(array());
		$huffman_tree_extra_bits = new _hx_array(array());
		encode_Entropy_encode::WriteHuffmanTree($depths, $depths_off, $num, $huffman_tree, $huffman_tree_extra_bits);
		$huffman_tree_histogram = FunctionMalloc::mallocInt(18);
		{
			$_g1 = 0;
			$_g = $huffman_tree->length;
			while($_g1 < $_g) {
				$_g1 = $_g1 + 1;
				{
					$_g2 = $huffman_tree[$_g1 - 1];
					$huffman_tree_histogram[$_g2] = $huffman_tree_histogram[$_g2] + 1;
					unset($_g2);
				}
			}
		}
		$num_codes = 0;
		$code = 0;
		{
			$_g3 = 0;
			while($_g3 < 18) {
				$_g3 = $_g3 + 1;
				$i = $_g3 - 1;
				if($huffman_tree_histogram[$i] > 0) {
					if($num_codes === 0) {
						$code = $i;
						$num_codes = 1;
					} else {
						if($num_codes === 1) {
							$num_codes = 2;
							break;
						}
					}
				}
				unset($i);
			}
		}
		$code_length_bitdepth = FunctionMalloc::mallocUInt(18);
		$code_length_bitdepth_symbols = FunctionMalloc::mallocUInt(18);
		encode_Entropy_encode::CreateHuffmanTree($huffman_tree_histogram, 0, 18, 5, $code_length_bitdepth, 0);
		encode_Entropy_encode::ConvertBitDepthsToSymbols($code_length_bitdepth, 0, 18, $code_length_bitdepth_symbols, 0);
		encode_Brotli_bit_stream::StoreHuffmanTreeOfHuffmanTreeToBitMask($num_codes, $code_length_bitdepth, $storage_ix, $storage);
		if($num_codes === 1) {
			$code_length_bitdepth[$code] = 0;
		}
		encode_Brotli_bit_stream::StoreHuffmanTreeToBitMask($huffman_tree, $huffman_tree_extra_bits, $code_length_bitdepth, 0, $code_length_bitdepth_symbols, $storage_ix, $storage);
	}
	static function BuildAndStoreHuffmanTree($histogram, $length, $depth, $depth_off, $bits, $bits_off, $storage_ix, $storage) {
		$count = 0;
		$s4 = (new _hx_array(array(0, 0, 0, 0)));
		{
			$_g1 = 0;
			while($_g1 < $length) {
				$_g1 = $_g1 + 1;
				$i = $_g1 - 1;
				if($histogram[$i] > 0) {
					if($count < 4) {
						$s4[$count] = $i;
					} else {
						if($count > 4) {
							break;
						}
					}
					$count = $count + 1;
				}
				unset($i);
			}
		}
		$max_bits_counter = $length - 1;
		$max_bits = 0;
		while($max_bits_counter > 0) {
			$max_bits_counter = $max_bits_counter >> 1;
			$max_bits = $max_bits + 1;
		}
		if($count <= 1) {
			encode_Write_bits::WriteBits(4, 1, $storage_ix, $storage);
			encode_Write_bits::WriteBits($max_bits, $s4[0], $storage_ix, $storage);
			return;
		}
		encode_Entropy_encode::CreateHuffmanTree($histogram, 0, $length, 15, $depth, $depth_off);
		encode_Entropy_encode::ConvertBitDepthsToSymbols($depth, $depth_off, $length, $bits, $bits_off);
		if($count <= 4) {
			encode_Brotli_bit_stream::StoreSimpleHuffmanTree($depth, $depth_off, $s4, $count, $max_bits, $storage_ix, $storage);
		} else {
			encode_Brotli_bit_stream::StoreHuffmanTree($depth, $depth_off, $length, $storage_ix, $storage);
		}
	}
	static function IndexOf($v, $value) {
		{
			$_g1 = 0;
			$_g = $v->length;
			while($_g1 < $_g) {
				$_g1 = $_g1 + 1;
				$i = $_g1 - 1;
				if($v[$i] === $value) {
					return $i;
				}
				unset($i);
			}
		}
		return -1;
	}
	static function MoveToFront($v, $index) {
		$value = $v[$index];
		$i = $index;
		while($i > 0) {
			$v[$i] = $v[$i - 1];
			$i = $i - 1;
		}
		$v[0] = $value;
	}
	static function MoveToFrontTransform($v) {
		if($v->length === 0) {
			return $v;
		}
		$max_element = 0;
		{
			$_g1 = 0;
			$_g = $v->length;
			while($_g1 < $_g) {
				$_g1 = $_g1 + 1;
				$i = $_g1 - 1;
				if($max_element < $v[$i]) {
					$max_element = $v[$i];
				}
				unset($i);
			}
		}
		$this1 = (new _hx_array(array()));
		$this1->length = $max_element + 1;
		$mtf = $this1;
		{
			$_g11 = 0;
			$_g2 = $mtf->length;
			while($_g11 < $_g2) {
				$_g11 = $_g11 + 1;
				$i1 = $_g11 - 1;
				$mtf[$i1] = $i1;
				unset($i1);
			}
		}
		$this2 = (new _hx_array(array()));
		$this2->length = $v->length;
		$result = $this2;
		{
			$_g12 = 0;
			$_g3 = $v->length;
			while($_g12 < $_g3) {
				$_g12 = $_g12 + 1;
				$i2 = $_g12 - 1;
				$index = encode_Brotli_bit_stream::IndexOf($mtf, $v[$i2]);
				$result[$i2] = $index;
				encode_Brotli_bit_stream::MoveToFront($mtf, $index);
				unset($index,$i2);
			}
		}
		return $result;
	}
	static function RunLengthCodeZeros($v_in, $max_run_length_prefix, $v_out, $extra_bits) {
		$max_reps = 0;
		$i = 0;
		while($i < $v_in->length) {
			while(true) {
				$tmp = null;
				if($i < $v_in->length) {
					$tmp = $v_in[$i] !== 0;
				} else {
					$tmp = false;
				}
				if(!$tmp) {
					break;
				}
				$i = $i + 1;
				unset($tmp);
			}
			$reps = 0;
			while(true) {
				$tmp1 = null;
				if($i < $v_in->length) {
					$tmp1 = $v_in[$i] === 0;
				} else {
					$tmp1 = false;
				}
				if(!$tmp1) {
					break;
				}
				$reps = $reps + 1;
				$i = $i + 1;
				unset($tmp1);
			}
			$max_reps = Std::int(Math::max($reps, $max_reps));
			unset($reps);
		}
		$max_prefix = null;
		if($max_reps > 0) {
			$max_prefix = encode_Fast_log::Log2Floor($max_reps);
		} else {
			$max_prefix = 0;
		}
		$max_run_length_prefix[0] = Std::int(Math::min($max_prefix, $max_run_length_prefix[0]));
		$i1 = 0;
		while($i1 < $v_in->length) {
			if($v_in[$i1] !== 0) {
				$v_out->push($v_in[$i1] + $max_run_length_prefix[0]);
				$extra_bits->push(0);
				$i1 = $i1 + 1;
			} else {
				$reps1 = 1;
				$k = $i1 + 1;
				while(true) {
					$tmp2 = null;
					if($k < $v_in->length) {
						$tmp2 = $v_in[$k] === 0;
					} else {
						$tmp2 = false;
					}
					if(!$tmp2) {
						break;
					}
					$reps1 = $reps1 + 1;
					$k = $k + 1;
					unset($tmp2);
				}
				$i1 = $i1 + $reps1;
				while($reps1 > 0) {
					if($reps1 < 2 << $max_run_length_prefix[0]) {
						$run_length_prefix = encode_Fast_log::Log2Floor($reps1);
						$v_out->push($run_length_prefix);
						$extra_bits->push($reps1 - (1 << $run_length_prefix));
						break;
						unset($run_length_prefix);
					} else {
						$v_out->push($max_run_length_prefix[0]);
						$extra_bits->push((1 << $max_run_length_prefix[0]) - 1);
						$reps1 = $reps1 - ((2 << $max_run_length_prefix[0]) - 1);
					}
				}
				unset($reps1,$k);
			}
		}
	}
	static function EncodeContextMap($context_map, $num_clusters, $storage_ix, $storage) {
		encode_Brotli_bit_stream::StoreVarLenUint8($num_clusters - 1, $storage_ix, $storage);
		if($num_clusters === 1) {
			return;
		}
		$transformed_symbols = encode_Brotli_bit_stream::MoveToFrontTransform($context_map);
		$rle_symbols = new _hx_array(array());
		$extra_bits = new _hx_array(array());
		$max_run_length_prefix = (new _hx_array(array(6)));
		encode_Brotli_bit_stream::RunLengthCodeZeros($transformed_symbols, $max_run_length_prefix, $rle_symbols, $extra_bits);
		$symbol_histogram = encode_Histogram_functions::HistogramContextMap();
		{
			$_g1 = 0;
			$_g = $rle_symbols->length;
			while($_g1 < $_g) {
				$_g1 = $_g1 + 1;
				$symbol_histogram->Add1($rle_symbols[$_g1 - 1]);
			}
		}
		$use_rle = $max_run_length_prefix->a[0] > 0;
		$tmp = null;
		if($use_rle) {
			$tmp = 1;
		} else {
			$tmp = 0;
		}
		encode_Write_bits::WriteBits(1, $tmp, $storage_ix, $storage);
		if($use_rle) {
			encode_Write_bits::WriteBits(4, $max_run_length_prefix->a[0] - 1, $storage_ix, $storage);
		}
		$symbol_code = encode_Entropy_encode::EntropyCodeContextMap();
		DefaultFunctions::memset_UInt($symbol_code->depth_, 0, 0, $symbol_code->depth_->length);
		DefaultFunctions::memset_UInt($symbol_code->bits_, 0, 0, $symbol_code->bits_->length);
		encode_Brotli_bit_stream::BuildAndStoreHuffmanTree($symbol_histogram->data_, $num_clusters + $max_run_length_prefix[0], $symbol_code->depth_, 0, $symbol_code->bits_, 0, $storage_ix, $storage);
		{
			$_g11 = 0;
			$_g2 = $rle_symbols->length;
			while($_g11 < $_g2) {
				$_g11 = $_g11 + 1;
				$i = $_g11 - 1;
				encode_Write_bits::WriteBits($symbol_code->depth_[$rle_symbols[$i]], $symbol_code->bits_[$rle_symbols[$i]], $storage_ix, $storage);
				$tmp1 = null;
				if($rle_symbols->a[$i] > 0) {
					$tmp1 = $rle_symbols->a[$i] <= $max_run_length_prefix[0];
				} else {
					$tmp1 = false;
				}
				if($tmp1) {
					encode_Write_bits::WriteBits($rle_symbols[$i], $extra_bits[$i], $storage_ix, $storage);
				}
				unset($tmp1,$i);
			}
		}
		encode_Write_bits::WriteBits(1, 1, $storage_ix, $storage);
	}
	static function StoreBlockSwitch($code, $block_ix, $storage_ix, $storage) {
		if($block_ix > 0) {
			$typecode = $code->type_code[$block_ix];
			encode_Write_bits::WriteBits($code->type_depths[$typecode], $code->type_bits[$typecode], $storage_ix, $storage);
		}
		$lencode = $code->length_prefix[$block_ix];
		encode_Write_bits::WriteBits($code->length_depths[$lencode], $code->length_bits[$lencode], $storage_ix, $storage);
		encode_Write_bits::WriteBits($code->length_nextra[$block_ix], $code->length_extra[$block_ix], $storage_ix, $storage);
	}
	static function BuildAndStoreBlockSplitCode($types, $lengths, $num_types, $code, $storage_ix, $storage) {
		$num_blocks = $types->length;
		$type_histo = FunctionMalloc::mallocInt($num_types + 2);
		$length_histo = FunctionMalloc::mallocInt(26);
		$last_type = 1;
		$second_last_type = 0;
		$code->type_code = FunctionMalloc::mallocInt($num_blocks);
		$code->length_prefix = FunctionMalloc::mallocInt($num_blocks);
		$code->length_nextra = FunctionMalloc::mallocInt($num_blocks);
		$code->length_extra = FunctionMalloc::mallocInt($num_blocks);
		$code->type_depths = FunctionMalloc::mallocUInt($num_types + 2);
		$code->type_bits = FunctionMalloc::mallocUInt($num_types + 2);
		$code->length_depths = FunctionMalloc::mallocUInt(26);
		$code->length_bits = FunctionMalloc::mallocUInt(26);
		{
			$_g1 = 0;
			while($_g1 < $num_blocks) {
				$_g1 = $_g1 + 1;
				$i = $_g1 - 1;
				$type = $types[$i];
				$type_code = null;
				if($type === $last_type + 1) {
					$type_code = 1;
				} else {
					if($type === $second_last_type) {
						$type_code = 0;
					} else {
						$type_code = $type + 2;
					}
				}
				$second_last_type = $last_type;
				$last_type = $type;
				$code->type_code[$i] = $type_code;
				if($i > 0) {
					$_g2 = $type_code;
					$type_histo[$_g2] = $type_histo[$_g2] + 1;
					unset($_g2);
				}
				encode_Prefix::GetBlockLengthPrefixCode($lengths[$i], $code->length_prefix, $i, $code->length_nextra, $i, $code->length_extra, $i);
				{
					$_g21 = $code->length_prefix[$i];
					$length_histo[$_g21] = $length_histo[$_g21] + 1;
					unset($_g21);
				}
				unset($type_code,$type,$i);
			}
		}
		encode_Brotli_bit_stream::StoreVarLenUint8($num_types - 1, $storage_ix, $storage);
		if($num_types > 1) {
			encode_Brotli_bit_stream::BuildAndStoreHuffmanTree($type_histo, $num_types + 2, $code->type_depths, 0, $code->type_bits, 0, $storage_ix, $storage);
			encode_Brotli_bit_stream::BuildAndStoreHuffmanTree($length_histo, 26, $code->length_depths, 0, $code->length_bits, 0, $storage_ix, $storage);
			encode_Brotli_bit_stream::StoreBlockSwitch($code, 0, $storage_ix, $storage);
		}
	}
	static function StoreTrivialContextMap($num_types, $context_bits, $storage_ix, $storage) {
		encode_Brotli_bit_stream::StoreVarLenUint8($num_types - 1, $storage_ix, $storage);
		if($num_types > 1) {
			$repeat_code = $context_bits - 1;
			$repeat_bits = (1 << $repeat_code) - 1;
			$alphabet_size = $num_types + $repeat_code;
			$histogram = FunctionMalloc::mallocInt($alphabet_size);
			$depths = FunctionMalloc::mallocUInt($alphabet_size);
			$bits = FunctionMalloc::mallocUInt($alphabet_size);
			encode_Write_bits::WriteBits(1, 1, $storage_ix, $storage);
			encode_Write_bits::WriteBits(4, $repeat_code - 1, $storage_ix, $storage);
			$histogram[$repeat_code] = $num_types;
			$histogram[0] = 1;
			{
				$_g1 = $context_bits;
				while($_g1 < $alphabet_size) {
					$_g1 = $_g1 + 1;
					$histogram[$_g1 - 1] = 1;
				}
			}
			encode_Brotli_bit_stream::BuildAndStoreHuffmanTree($histogram, $alphabet_size, $depths, 0, $bits, 0, $storage_ix, $storage);
			{
				$_g11 = 0;
				while($_g11 < $num_types) {
					$_g11 = $_g11 + 1;
					$i = $_g11 - 1;
					$code = null;
					if($i === 0) {
						$code = 0;
					} else {
						$code = $i + $context_bits - 1;
					}
					encode_Write_bits::WriteBits($depths[$code], $bits[$code], $storage_ix, $storage);
					encode_Write_bits::WriteBits($depths[$repeat_code], $bits[$repeat_code], $storage_ix, $storage);
					encode_Write_bits::WriteBits($repeat_code, $repeat_bits, $storage_ix, $storage);
					unset($i,$code);
				}
			}
			encode_Write_bits::WriteBits(1, 1, $storage_ix, $storage);
		}
	}
	static function JumpToByteBoundary($storage_ix, $storage) {
		$storage_ix[0] = $storage_ix->a[0] + 7 & -8;
		$storage[$storage_ix->a[0] >> 3] = 0;
	}
	static function StoreMetaBlock($input, $start_pos, $length, $mask, $prev_byte, $prev_byte2, $is_last, $num_direct_distance_codes, $distance_postfix_bits, $literal_context_mode, $commands, $n_commands, $mb, $storage_ix, $storage) {
		if(!encode_Brotli_bit_stream::StoreCompressedMetaBlockHeader($is_last, $length, $storage_ix, $storage)) {
			return false;
		}
		if($length === 0) {
			encode_Brotli_bit_stream::JumpToByteBoundary($storage_ix, $storage);
			return true;
		}
		$literal_enc = new encode_brotli_bit_stream_BlockEncoder(256, $mb->literal_split->num_types, $mb->literal_split->types, $mb->literal_split->lengths);
		$command_enc = new encode_brotli_bit_stream_BlockEncoder(704, $mb->command_split->num_types, $mb->command_split->types, $mb->command_split->lengths);
		$distance_enc = new encode_brotli_bit_stream_BlockEncoder(16 + $num_direct_distance_codes + (48 << $distance_postfix_bits), $mb->distance_split->num_types, $mb->distance_split->types, $mb->distance_split->lengths);
		$literal_enc->BuildAndStoreBlockSwitchEntropyCodes($storage_ix, $storage);
		$command_enc->BuildAndStoreBlockSwitchEntropyCodes($storage_ix, $storage);
		$distance_enc->BuildAndStoreBlockSwitchEntropyCodes($storage_ix, $storage);
		encode_Write_bits::WriteBits(2, $distance_postfix_bits, $storage_ix, $storage);
		encode_Write_bits::WriteBits(4, $num_direct_distance_codes >> $distance_postfix_bits, $storage_ix, $storage);
		{
			$_g1 = 0;
			$_g = $mb->literal_split->num_types;
			while($_g1 < $_g) {
				$_g1 = $_g1 + 1;
				encode_Write_bits::WriteBits(2, $literal_context_mode, $storage_ix, $storage);
			}
		}
		if($mb->literal_context_map->length === 0) {
			encode_Brotli_bit_stream::StoreTrivialContextMap($mb->literal_histograms->length, 6, $storage_ix, $storage);
		} else {
			encode_Brotli_bit_stream::EncodeContextMap($mb->literal_context_map, $mb->literal_histograms->length, $storage_ix, $storage);
		}
		if($mb->distance_context_map->length === 0) {
			encode_Brotli_bit_stream::StoreTrivialContextMap($mb->distance_histograms->length, 2, $storage_ix, $storage);
		} else {
			encode_Brotli_bit_stream::EncodeContextMap($mb->distance_context_map, $mb->distance_histograms->length, $storage_ix, $storage);
		}
		$literal_enc->BuildAndStoreEntropyCodes($mb->literal_histograms, $storage_ix, $storage);
		$command_enc->BuildAndStoreEntropyCodes($mb->command_histograms, $storage_ix, $storage);
		$distance_enc->BuildAndStoreEntropyCodes($mb->distance_histograms, $storage_ix, $storage);
		$pos = $start_pos;
		{
			$_g11 = 0;
			while($_g11 < $n_commands) {
				$_g11 = $_g11 + 1;
				$cmd = $commands[$_g11 - 1];
				$lennumextra = _hx_shift_right($cmd->cmd_extra_[0], 16);
				$lenextra = $cmd->cmd_extra_;
				$command_enc->StoreSymbol($cmd->cmd_prefix_[0], $storage_ix, $storage);
				if($lennumextra >= 32) {
					encode_Write_bits::WriteBits($lennumextra - 32, $lenextra[0], $storage_ix, $storage);
				}
				$tmp = null;
				if($lennumextra < 32) {
					$tmp = $lennumextra;
				} else {
					$tmp = 32;
				}
				encode_Write_bits::WriteBits($tmp, $lenextra[1], $storage_ix, $storage);
				if($mb->literal_context_map->length === 0) {
					$_g3 = 0;
					$_g2 = $cmd->insert_len_;
					while($_g3 < $_g2) {
						$_g3 = $_g3 + 1;
						$literal_enc->StoreSymbol($input[$pos & $mask], $storage_ix, $storage);
						$pos = $pos + 1;
					}
					unset($_g3,$_g2);
				} else {
					$_g31 = 0;
					$_g21 = $cmd->insert_len_;
					while($_g31 < $_g21) {
						$_g31 = $_g31 + 1;
						$literal = $input[$pos & $mask];
						$literal_enc->StoreSymbolWithContext(6, $literal, encode_Context::ContextFunction($prev_byte, $prev_byte2, $literal_context_mode), $mb->literal_context_map, $storage_ix, $storage);
						$prev_byte2 = $prev_byte;
						$prev_byte = $literal;
						$pos = $pos + 1;
						unset($literal);
					}
					unset($_g31,$_g21);
				}
				$pos = $pos + $cmd->copy_len_;
				if($cmd->copy_len_ > 0) {
					$prev_byte2 = $input[$pos - 2 & $mask];
					$prev_byte = $input[$pos - 1 & $mask];
					$a = $cmd->cmd_prefix_[0];
					$aNeg = $a < 0;
					$tmp1 = null;
					if($aNeg !== false) {
						$tmp1 = $aNeg;
					} else {
						$tmp1 = $a >= 128;
					}
					if($tmp1) {
						$dist_code = $cmd->dist_prefix_[0];
						$distnumextra = _hx_shift_right($cmd->dist_extra_[0], 24);
						$distextra = $cmd->dist_extra_[0] & 16777215;
						if($mb->distance_context_map->length === 0) {
							$distance_enc->StoreSymbol($dist_code, $storage_ix, $storage);
						} else {
							$distance_enc->StoreSymbolWithContext(2, $dist_code, $cmd->DistanceContext(), $mb->distance_context_map, $storage_ix, $storage);
						}
						encode_Write_bits::WriteBits($distnumextra, $distextra, $storage_ix, $storage);
						unset($distnumextra,$distextra,$dist_code);
					}
					unset($tmp1,$aNeg,$a);
				}
				unset($tmp,$lennumextra,$lenextra,$cmd);
			}
		}
		if($is_last) {
			encode_Brotli_bit_stream::JumpToByteBoundary($storage_ix, $storage);
		}
		return true;
	}
	static function StoreMetaBlockTrivial($input, $start_pos, $length, $mask, $is_last, $commands, $n_commands, $storage_ix, $storage, $storage_off) {
		if(!encode_Brotli_bit_stream::StoreCompressedMetaBlockHeader($is_last, $length, $storage_ix, $storage)) {
			return false;
		}
		if($length === 0) {
			encode_Brotli_bit_stream::JumpToByteBoundary($storage_ix, $storage);
			return true;
		}
		$lit_histo = encode_Histogram_functions::HistogramLiteral();
		$cmd_histo = encode_Histogram_functions::HistogramCommand();
		$dist_histo = encode_Histogram_functions::HistogramDistance();
		$pos = $start_pos;
		{
			$_g1 = 0;
			while($_g1 < $n_commands) {
				$_g1 = $_g1 + 1;
				$cmd = $commands[$_g1 - 1];
				$cmd_histo->Add1($cmd->cmd_prefix_[0]);
				{
					$_g3 = 0;
					$_g2 = $cmd->insert_len_;
					while($_g3 < $_g2) {
						$_g3 = $_g3 + 1;
						$lit_histo->Add1($input[$pos & $mask]);
						$pos = $pos + 1;
					}
					unset($_g3,$_g2);
				}
				$pos = $pos + $cmd->copy_len_;
				$tmp = null;
				if($cmd->copy_len_ > 0) {
					$a = $cmd->cmd_prefix_[0];
					$aNeg = $a < 0;
					if($aNeg !== false) {
						$tmp = $aNeg;
					} else {
						$tmp = $a >= 128;
					}
					unset($aNeg,$a);
				} else {
					$tmp = false;
				}
				if($tmp) {
					$dist_histo->Add1($cmd->dist_prefix_[0]);
				}
				unset($tmp,$cmd);
			}
		}
		encode_Write_bits::WriteBits(13, 0, $storage_ix, $storage);
		$lit_depth = FunctionMalloc::mallocUInt(256);
		$lit_bits = FunctionMalloc::mallocUInt(256);
		$cmd_depth = FunctionMalloc::mallocUInt(704);
		$cmd_bits = FunctionMalloc::mallocUInt(704);
		$dist_depth = FunctionMalloc::mallocUInt(64);
		$dist_bits = FunctionMalloc::mallocUInt(64);
		encode_Brotli_bit_stream::BuildAndStoreHuffmanTree($lit_histo->data_, 256, $lit_depth, 0, $lit_bits, 0, $storage_ix, $storage);
		encode_Brotli_bit_stream::BuildAndStoreHuffmanTree($cmd_histo->data_, 704, $cmd_depth, 0, $cmd_bits, 0, $storage_ix, $storage);
		encode_Brotli_bit_stream::BuildAndStoreHuffmanTree($dist_histo->data_, 64, $dist_depth, 0, $dist_bits, 0, $storage_ix, $storage);
		$pos = $start_pos;
		{
			$_g11 = 0;
			while($_g11 < $n_commands) {
				$_g11 = $_g11 + 1;
				$cmd1 = $commands[$_g11 - 1];
				$cmd_code = $cmd1->cmd_prefix_[0];
				$lennumextra = _hx_shift_right($cmd1->cmd_extra_[0], 16);
				$lenextra = $cmd1->cmd_extra_;
				encode_Write_bits::WriteBits($cmd_depth[$cmd_code], $cmd_bits[$cmd_code], $storage_ix, $storage);
				if($lennumextra >= 32) {
					encode_Write_bits::WriteBits($lennumextra - 32, $lenextra[0], $storage_ix, $storage);
				}
				$tmp1 = null;
				if($lennumextra < 32) {
					$tmp1 = $lennumextra;
				} else {
					$tmp1 = 32;
				}
				encode_Write_bits::WriteBits($tmp1, $lenextra[1], $storage_ix, $storage);
				{
					$_g31 = 0;
					$_g21 = $cmd1->insert_len_;
					while($_g31 < $_g21) {
						$_g31 = $_g31 + 1;
						$literal = $input[$pos & $mask];
						encode_Write_bits::WriteBits($lit_depth[$literal], $lit_bits[$literal], $storage_ix, $storage);
						$pos = $pos + 1;
						unset($literal);
					}
					unset($_g31,$_g21);
				}
				$pos = $pos + $cmd1->copy_len_;
				$tmp2 = null;
				if($cmd1->copy_len_ > 0) {
					$a1 = $cmd1->cmd_prefix_[0];
					$aNeg1 = $a1 < 0;
					if($aNeg1 !== false) {
						$tmp2 = $aNeg1;
					} else {
						$tmp2 = $a1 >= 128;
					}
					unset($aNeg1,$a1);
				} else {
					$tmp2 = false;
				}
				if($tmp2) {
					$dist_code = $cmd1->dist_prefix_[0];
					$distnumextra = _hx_shift_right($cmd1->dist_extra_[0], 24);
					$distextra = $cmd1->dist_extra_[0] & 16777215;
					encode_Write_bits::WriteBits($dist_depth[$dist_code], $dist_bits[$dist_code], $storage_ix, $storage);
					encode_Write_bits::WriteBits($distnumextra, $distextra, $storage_ix, $storage);
					unset($distnumextra,$distextra,$dist_code);
				}
				unset($tmp2,$tmp1,$lennumextra,$lenextra,$cmd_code,$cmd1);
			}
		}
		if($is_last) {
			encode_Brotli_bit_stream::JumpToByteBoundary($storage_ix, $storage);
		}
		return true;
	}
	static function StoreUncompressedMetaBlock($final_block, $input, $position, $mask, $len, $storage_ix, $storage, $storage_off) {
		if(!encode_Brotli_bit_stream::StoreUncompressedMetaBlockHeader($len, $storage_ix, $storage)) {
			return false;
		}
		encode_Brotli_bit_stream::JumpToByteBoundary($storage_ix, $storage);
		$masked_pos = $position & $mask;
		if($masked_pos + $len > $mask + 1) {
			$len1 = $mask + 1 - $masked_pos;
			DefaultFunctions::memcpy_UInt($storage, $storage_ix->a[0] >> 3, $input, $masked_pos, $len1);
			$storage_ix[0] = $storage_ix->a[0] + ($len1 << 3);
			$len = $len - $len1;
			$masked_pos = 0;
		}
		DefaultFunctions::memcpy_UInt($storage, $storage_ix->a[0] >> 3, $input, $masked_pos, $len);
		$storage_ix[0] = $storage_ix->a[0] + ($len << 3);
		encode_Write_bits::WriteBitsPrepareStorage($storage_ix[0], $storage);
		if($final_block) {
			encode_Write_bits::WriteBits(1, 1, $storage_ix, $storage);
			encode_Write_bits::WriteBits(1, 1, $storage_ix, $storage);
			encode_Brotli_bit_stream::JumpToByteBoundary($storage_ix, $storage);
		}
		return true;
	}
	function __toString() { return 'encode.Brotli_bit_stream'; }
}

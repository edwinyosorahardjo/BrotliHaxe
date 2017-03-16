<?php

// Generated by Haxe 3.4.0
class decode_Streams {
	public function __construct() {}
	static function BrotliRead($input, $buf, $buf_off, $len) {
		return $input->cb_($input->data_, $buf, $buf_off, $len);
	}
	static function BrotliWrite($out, $buf, $buf_off, $len) {
		return $out->cb_($out->data_, $buf, $buf_off, $len);
	}
	static function BrotliMemInputFunction($data, $buf, $buf_off, $count) {
		$a = $data->pos;
		$b = $data->length;
		$aNeg = $a < 0;
		$tmp = null;
		if($aNeg !== $b < 0) {
			$tmp = $aNeg;
		} else {
			$tmp = $a > $b;
		}
		if($tmp) {
			return -1;
		}
		$a1 = $data->pos + $count;
		$b1 = $data->length;
		$aNeg1 = $a1 < 0;
		$tmp1 = null;
		if($aNeg1 !== $b1 < 0) {
			$tmp1 = $aNeg1;
		} else {
			$tmp1 = $a1 > $b1;
		}
		if($tmp1) {
			$count = $data->length - $data->pos;
		}
		DefaultFunctions::memcpyVectorArray($buf, $buf_off, $data->buffer, 0 + $data->pos, $count);
		$data->pos = $data->pos + $count;
		return $count;
	}
	static function BrotliInitMemInput($buffer, $length) {
		$input = new decode_streams_BrotliInput();
		$mem_input = new decode_streams_BrotliMemInput();
		$mem_input->buffer = $buffer;
		$mem_input->length = $length;
		$mem_input->pos = 0;
		$input->cb_ = (property_exists("decode_Streams", "BrotliMemInputFunction") ? decode_Streams::$BrotliMemInputFunction: array("decode_Streams", "BrotliMemInputFunction"));
		$input->data_ = $mem_input;
		return $input;
	}
	static function BrotliMemOutputFunction($data, $buf, $buf_off, $count) {
		DefaultFunctions::memcpyArrayVector($data->buffer, 0 + $data->pos, $buf, $buf_off, $count);
		$data->pos = $data->pos + $count;
		return $count;
	}
	static function BrotliInitMemOutput($buffer) {
		$output = new decode_streams_BrotliOutput();
		$mem_output = new decode_streams_BrotliMemOutput();
		$mem_output->buffer = $buffer;
		$mem_output->pos = 0;
		$output->cb_ = (property_exists("decode_Streams", "BrotliMemOutputFunction") ? decode_Streams::$BrotliMemOutputFunction: array("decode_Streams", "BrotliMemOutputFunction"));
		$output->data_ = $mem_output;
		return $output;
	}
	static function BrotliFileInputFunction($data, $buf, $buf_off, $count) {
		$bytes = haxe_io_Bytes::alloc($count);
		$size = $data->readBytes($bytes, 0, $count);
		{
			$_g1 = 0;
			$_g = $size;
			while($_g1 < $_g) {
				$_g1 = $_g1 + 1;
				$i = $_g1 - 1;
				{
					$this1 = $bytes->b;
					$buf[$buf_off + $i] = ord($this1->s[$i]);
					unset($this1);
				}
				unset($i);
			}
		}
		return $size;
	}
	static function BrotliFileInput($f) {
		$input = new decode_streams_BrotliInput();
		$input->cb_ = (property_exists("decode_Streams", "BrotliFileInputFunction") ? decode_Streams::$BrotliFileInputFunction: array("decode_Streams", "BrotliFileInputFunction"));
		$input->data_ = $f;
		return $input;
	}
	static function BrotliFileOutputFunction($data, $buf, $buf_off, $count) {
		print memory_get_usage()."<br>
";;
		$bytes = haxe_io_Bytes::alloc($count);
		{
			$_g1 = 0;
			$_g = $count;
			while($_g1 < $_g) {
				$_g1 = $_g1 + 1;
				$i = $_g1 - 1;
				{
					$this1 = $bytes->b;
					$this1->s[$i] = chr($buf[$i]);
					unset($this1);
				}
				unset($i);
			}
		}
		$data->write($bytes);
		return $bytes->length;
	}
	static function BrotliFileOutput($f) {
		$out = new decode_streams_BrotliOutput();
		$out->cb_ = (property_exists("decode_Streams", "BrotliFileOutputFunction") ? decode_Streams::$BrotliFileOutputFunction: array("decode_Streams", "BrotliFileOutputFunction"));
		$out->data_ = $f;
		return $out;
	}
	function __toString() { return 'decode.Streams'; }
}

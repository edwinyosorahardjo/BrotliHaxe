<?php

// Generated by Haxe 3.4.0
class DefaultFunctions {
	public function __construct() {}
	static function memcpy_Int($dst, $dst_offset, $src, $src_offset, $count) {
		$_g1 = 0;
		while($_g1 < $count) {
			$_g1 = $_g1 + 1;
			$i = $_g1 - 1;
			$dst[$dst_offset + $i] = $src[$src_offset + $i];
			unset($i);
		}
	}
	static function memset_Int($b, $offset, $v, $count) {
		$_g1 = 0;
		while($_g1 < $count) {
			$_g1 = $_g1 + 1;
			$b[$offset + ($_g1 - 1)] = $v;
		}
	}
	static function memcpy_UInt($dst, $dst_offset, $src, $src_offset, $count) {
		$_g1 = 0;
		while($_g1 < $count) {
			$_g1 = $_g1 + 1;
			$i = $_g1 - 1;
			$dst[$dst_offset + $i] = $src[$src_offset + $i];
			unset($i);
		}
	}
	static function memset_UInt($b, $offset, $v, $count) {
		$_g1 = 0;
		while($_g1 < $count) {
			$_g1 = $_g1 + 1;
			$b[$offset + ($_g1 - 1)] = $v;
		}
	}
	static function memcpyArray($dst, $dst_offset, $src, $src_offset, $count) {
		$_g1 = 0;
		while($_g1 < $count) {
			$_g1 = $_g1 + 1;
			$i = $_g1 - 1;
			$dst[$dst_offset + $i] = $src[$src_offset + $i];
			unset($i);
		}
	}
	static function memcpyVectorArray($dst, $dst_offset, $src, $src_offset, $count) {
		$_g1 = 0;
		while($_g1 < $count) {
			$_g1 = $_g1 + 1;
			$i = $_g1 - 1;
			$dst[$dst_offset + $i] = $src[$src_offset + $i];
			unset($i);
		}
	}
	static function memcpyArrayVector($dst, $dst_offset, $src, $src_offset, $count) {
		$_g1 = 0;
		while($_g1 < $count) {
			$_g1 = $_g1 + 1;
			$i = $_g1 - 1;
			$dst[$dst_offset + $i] = $src[$src_offset + $i];
			unset($i);
		}
	}
	function __toString() { return 'DefaultFunctions'; }
}

<?php

// Generated by Haxe 3.4.0
class encode_metablock_BlockSplit {
	public function __construct() {
		if(!php_Boot::$skip_constructor) {
		$this->lengths = new _hx_array(array());
		$this->types = new _hx_array(array());
		$this->num_types = 0;
	}}
	public $num_types;
	public $types;
	public $lengths;
	public function __call($m, $a) {
		if(isset($this->$m) && is_callable($this->$m))
			return call_user_func_array($this->$m, $a);
		else if(isset($this->__dynamics[$m]) && is_callable($this->__dynamics[$m]))
			return call_user_func_array($this->__dynamics[$m], $a);
		else if('toString' == $m)
			return $this->__toString();
		else
			throw new HException('Unable to call <'.$m.'>');
	}
	function __toString() { return 'encode.metablock.BlockSplit'; }
}

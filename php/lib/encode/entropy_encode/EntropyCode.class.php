<?php

// Generated by Haxe 3.4.0
class encode_entropy_encode_EntropyCode {
	public function __construct($kSize) {
		if(!php_Boot::$skip_constructor) {
		$this->symbols_ = FunctionMalloc::mallocUInt(4);
		$this->depth_ = FunctionMalloc::mallocUInt($kSize);
		$this->bits_ = FunctionMalloc::mallocUInt($kSize);
	}}
	public $depth_;
	public $bits_;
	public $count_;
	public $symbols_;
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
	function __toString() { return 'encode.entropy_encode.EntropyCode'; }
}

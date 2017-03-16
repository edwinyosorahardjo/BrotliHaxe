<?php

// Generated by Haxe 3.4.0
class encode_block_splitter_BlockSplitIterator {
	public function __construct($split) {
		if(!php_Boot::$skip_constructor) {
		$this->split_ = $split;
		$this->idx_ = 0;
		$this->type_ = 0;
		$this->length_ = 0;
		if($split->lengths->length !== 0) {
			$this->length_ = $split->lengths[0];
		}
	}}
	public function Next() {
		if($this->length_ === 0) {
			++$this->idx_;
			$this->type_ = $this->split_->types[$this->idx_];
			$this->length_ = $this->split_->lengths[$this->idx_];
		}
		--$this->length_;
	}
	public $split_;
	public $idx_;
	public $type_;
	public $length_;
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
	function __toString() { return 'encode.block_splitter.BlockSplitIterator'; }
}

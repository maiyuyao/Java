package com.essence.base.d07_interface.ex02;

public class SuperStorageAdapter implements IMobileStorage {
	//适配器模式
	private SuperStorage _superStorage;

	public SuperStorage get_superStorage() {
		return _superStorage;
	}

	public void set_superStorage(SuperStorage _superStorage) {
		this._superStorage = _superStorage;
	}

	@Override
	public void Read() {
		this._superStorage.rd();
	}

	@Override
	public void Write() {
		this._superStorage.wt();
	}
}

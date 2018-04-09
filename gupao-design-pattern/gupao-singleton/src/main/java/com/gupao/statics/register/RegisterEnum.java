package com.gupao.statics.register;

/**
 * 枚举式单例
 * 只会加载一次
 */
public enum  RegisterEnum {
	RED(){
		String color = "red";

		@Override
		public String toString() {
			return this.color;
		}
	},
	BLACK(){
		String color = "black";
		@Override
		public String toString() {
			return this.color;
		}
	}
}

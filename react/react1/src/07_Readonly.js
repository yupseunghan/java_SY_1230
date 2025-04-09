import { useState } from "react";

/*
읽기 버튼을 클릭하면 인렵창이 읽기전용으로 변경되고 버튼 글자가 쓰기로 변경
쓰기 번튼을 클릭하면 입력창이 쓸수 있도록 변경되고 버튼 글자가 읽기로 변경
*/
function ReadOnly(){
	let [readonly,isReadOnly] = useState(false);
	let [text,setText] = useState("읽기");
	function toggle(){
		if(!readonly){
			setText("쓰기");
		}else{
			setText("읽기");
		}
		isReadOnly(!readonly);
	}
	return(
		<div>
			<input readOnly={readonly}/>
			<button onClick={toggle}>{text}</button>
		</div>
	);
}
export default ReadOnly;ㅇ
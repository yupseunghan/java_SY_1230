import { useState } from "react";

/*
버튼을 클릭하면 input에 입력된오늘의 할일에 등록하는 작업
*/
function StateSample4(){
	let [todo,setTodo] = useState("");
	let [todoList,setTodoList]=useState([]);
	function addTodo(){
		setTodoList([...todoList,todo]);
	}
	return(
		<div>
			<input type="text" onChange={(e)=> setTodo(e.target.value)}/>
			<button onClick={addTodo}>등록</button>
			<h1>오늘의 할일</h1>
			<ul>
				{
					todoList.map(v=>{
						return <li>{v}</li>
					})
				}
			</ul>
		</div>
	);
}
export default StateSample4;
import { useState } from "react";

/*
m->cm를 클릭하면 위 입력창이 쓰기모드로,
cm->m를 클릭하면 아래 입력창이 쓰기모드로 변환되도록 작성
*/
function Convert(){
	
	return(
		<div>
			<button>m-&gt;cm</button>
			<button>cm-&gt;m</button>
			<div>
				<input type="number" disabled={false}/>
				<button >변환</button>
			</div>
			<input type="number" disabled={true}/>
		</div>
	);
}
export default Convert;

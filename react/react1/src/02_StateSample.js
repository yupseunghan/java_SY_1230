import {useState} from "react";
import { Button } from "./Button";

function StateSample(){
	let [page,setPage] = useState(2);
	const maxPage=6;
	function decrease(){
		page --;
		if(page < 1){
			page = maxPage;
		}
		setPage(page);
	}
	const increase = function(){
		page ++;
		if(page > maxPage){
			page = 1;
		}
		setPage(page);
	}
	function add(amount){
		page = page + amount;
		if(page < 1){
			page = maxPage;
		}
		if(page > maxPage){
			page =1;
		}
		setPage(page);
	}
	return(
		<div>
			{/* <Button text={"-"} click={decrease}/> */}
			<Button text={"-"} click={()=>add(-1)}/>
			<span>{page}</span>
			<span>/{maxPage}</span>
			{/* <Button text={"+"} click={()=>increase()}/> */}
			<Button text={"+"} click={()=>add(1)}/>
		</div>
	);
}
export default StateSample;
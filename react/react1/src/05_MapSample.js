

function StateSample4(){
	let title=["아침","점심","저녁","간식"];
	return(
		<div>
			<ul>
				{
					title.map((v,i,arr)=>{
						return <li>{v}</li>
					})
				}
			</ul>
		</div>
	);
}
export default StateSample4;
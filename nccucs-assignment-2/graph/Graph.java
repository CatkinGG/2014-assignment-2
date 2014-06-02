package ps3.graph;
import java.util.*;

public class Graph<E>{
	private HashMap<E,HashSet<E>> graphNode;
	
	public Graph(){
		graphNode = new HashMap<E,HashSet<E>>();
	}
	public boolean addNode(E n)
	/*
	*@requires n尚未存在於graph當中
	*@effects Graph中的nodes將新增n
	*@return 成功新增node回傳true, 失敗回傳false
	*/
	{
		if(!nodeExist(n)){
			graphNode.put(n,null);
			return true;
			}
		return false;
	}

	public boolean addEdge(E n1,E n2)
	/*
	*@requires n1,n2必須都存在於graph中
	*@effects 創造一個從n1出發, 指向n2的edge
	*@return 成功新增edge回傳true, 失敗回傳false
	*/
	{
		if(nodeExist(n1)&&nodeExist(n2)){
			HashSet<E> temp = graphNode.get(n1);
			temp.add(n2);
			graphNode.put(n1, temp);
		}
		return false;
	}
	
	public Set<E> listNode()
	/*
	*@requires 無(只要圖存在, 空圖也可)
	*@effects 列出此graph中所有的nodes
	*@return Set of nodes
	*/
	{
		Set<E> temp = graphNode.keySet();
		return temp;
	}
	
	public Set<E> listEdge(E n)
	/*
	*@requires n必須存在於graph中
	*@effects 列出此node所有連出去的edges, 以目的nodes為回傳對象
	*@return Set of nodes
	*/
	{
		if(nodeExist(n)){
			Set<E> temp = graphNode.get(n);
			return temp;
		}
		return null;
	}
	
	private boolean nodeExist(E n)
	/*
	*@requires 無
	*@effects 測試此node有無存在於graph當中
	*@return 存在回傳true, 不存在回傳false
	*/
	{
		if(graphNode.containsKey(n))
			return true;
		else 
			return false;
	}
}

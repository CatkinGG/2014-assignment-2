package ps3.graph;
import java.util.*;

public class Graph<E>{
	private HashMap<E,HashSet<E>> graphNode;
	
	public Graph(){
		graphNode = new HashMap<E,HashSet<E>>();
	}
	public boolean addNode(E n)
	/*
	*@requires n�|���s�b��graph��
	*@effects Graph����nodes�N�s�Wn
	*@return ���\�s�Wnode�^��true, ���Ѧ^��false
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
	*@requires n1,n2�������s�b��graph��
	*@effects �гy�@�ӱqn1�X�o, ���Vn2��edge
	*@return ���\�s�Wedge�^��true, ���Ѧ^��false
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
	*@requires �L(�u�n�Ϧs�b, �ŹϤ]�i)
	*@effects �C�X��graph���Ҧ���nodes
	*@return Set of nodes
	*/
	{
		Set<E> temp = graphNode.keySet();
		return temp;
	}
	
	public Set<E> listEdge(E n)
	/*
	*@requires n�����s�b��graph��
	*@effects �C�X��node�Ҧ��s�X�h��edges, �H�ت�nodes���^�ǹ�H
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
	*@requires �L
	*@effects ���զ�node���L�s�b��graph��
	*@return �s�b�^��true, ���s�b�^��false
	*/
	{
		if(graphNode.containsKey(n))
			return true;
		else 
			return false;
	}
}

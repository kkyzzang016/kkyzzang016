package Basic;
public class EncapEx {

	/* ����������
	 		- ��ü�� ����� �����ϱ� ���� ������
	 	����)
	 		-private = Ŭ���� �������� ��밡��
	 		 default  = ���� ��Ű�� �ȿ����� ��밡��
	 		 protected = ��Ӱ���(extends)��� �ܺ� ��Ű�� �͵� ��밡��
	 		 public = ��� ��밡��
	 		
	 	����)
	 		-Ŭ���� ǥ��
	 			[����������]		class	Ŭ����
	 			
	 		-�޼��� ǥ��
	 			[����������]		[�ڷ���]	�޼����	(���ڵ�){
	 			}
	 		-���� ǥ��
	 			[����������]		[�ڷ���]	������ = ������;
	 			
	 		-������ ǥ��
	 			[����������]		Ŭ������(���ڵ�){
	 			}*/
	
	public static void main(String[] args) {
		Encap ec = new Encap();
		ec.setA(50);
		int su1 = ec.getA();  // �ش� Ŭ������ ���ٰ���
		int su2 = ec.b;	   // ���� ��Ű��
		int su3 = ec.c;	   // ���� ��Ű��, ���
		int su4 = ec.d;    // ��ü ����(����)
	}
}

class Encap {
	private int a=10;
	int b=20;
	protected int c=30;
	public int d=40;
	public void setA(int a) {
		this.a=a;
	}
	public int getA() {
		return this.a;
	}
	
}
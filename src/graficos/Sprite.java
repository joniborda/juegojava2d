package graficos;

public class Sprite {
	private final int lado;
	private int x;
	private int y;
	
	public int[] pixeles;
	private final HojaSprites hoja;
	
        // coleccion de sprites
        public static Sprite asfalto = new Sprite(32, 0, 0, HojaSprites.desierto);
        
	public Sprite(int lado, final int columna, final int fila, final HojaSprites hoja) {
		this.lado = lado;
		this.pixeles = new int[lado * lado];
		this.x = columna * lado;
		this.y = fila * lado;
		this.hoja = hoja;
		
		for (int i = 0; i < lado; i++) {
			for (int x = 0; x < lado; x++) {
				pixeles[x + y * lado] = this.hoja.pixeles[(x + this.x) + (y + this.y) * hoja.obtenAncho()];
			}
		}
	}
	
}

package controller;

import view.GamePanel;
import model.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TileManager {

    GamePanel gp;
    public int maxWorldCol = 300;
    public Tile[] tiles;
    public int[][] mapTileNum = new int [18][maxWorldCol];


    public TileManager(GamePanel gp , String path){

        this.gp = gp;
        tiles = new Tile[10];
        this.getTileImage();
        this.loadMap(path);
    }

    public void getTileImage(){

        try{
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(Files.newInputStream(Paths.get("res/tile/block.png")));
            tiles[0].collision = true;

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(Files.newInputStream(Paths.get("res/tile/break.png")));
            tiles[1].collision = true;

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(Files.newInputStream(Paths.get("res/tile/leftPipe.png")));
            tiles[2].collision = true;

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(Files.newInputStream(Paths.get("res/tile/rightPipe.png")));
            tiles[3].collision = true;

            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(Files.newInputStream(Paths.get("res/tile/upLeftPipe.png")));
            tiles[4].collision = true;

            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(Files.newInputStream(Paths.get("res/tile/upRightPipe.png")));
            tiles[5].collision = true;

            tiles[6] = new Tile();

            tiles[7] =new Tile();
            tiles[7].image = ImageIO.read(Files.newInputStream(Paths.get("res/tile/stair.png")));
            tiles[7].collision = true;

            tiles[8] =new Tile();
            tiles[8].image = ImageIO.read(Files.newInputStream(Paths.get("res/tile/blueBlock.png")));
            tiles[8].collision = true;

            tiles[9] =new Tile();
            tiles[9].image = ImageIO.read(Files.newInputStream(Paths.get("res/tile/blueBreak.png")));
            tiles[9].collision = true;

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String path){

        try{
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));

            int col = 0;
            int row = 0;

            while (col < maxWorldCol && row <18){

                String line = br.readLine();

                while (col < maxWorldCol) {

                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                    col++;
                }
                if(col == maxWorldCol){
                    col = 0;
                    row++;
                }
            }


        }  catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g) {
        int row = 0;
        int col = 0;

        while (col < maxWorldCol && row <18){

            while (col < maxWorldCol) {

                int screenX = (col * 50) - gp.playerCharacter.getWorldX() +gp.playerCharacter.screenX;

                if (mapTileNum[row][col] != 6) {

                    if(col * 50 >= gp.playerCharacter.getWorldX() - gp.playerCharacter.screenX- 50 &&
                            col *50 <= gp.playerCharacter.getWorldX()+ (1500 -gp.playerCharacter.screenX)) {
                        g.drawImage(tiles[mapTileNum[row][col]].image, screenX, row * 50, 50, 50, null);
                    }
                }
                col++;
            }
            if(col == maxWorldCol){
                col = 0;
                row++;
            }
        }
    }
}

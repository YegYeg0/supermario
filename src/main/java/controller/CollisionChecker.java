package controller;

import view.GamePanel;
import model.PlayerCharacter;

public class CollisionChecker {

    public GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(PlayerCharacter playerCharacter) {
        int pLeftX = playerCharacter.getWorldX() + playerCharacter.solidArea.x;
        int pRightX = playerCharacter.getWorldX() + playerCharacter.solidArea.x + playerCharacter.solidArea.width;
        int pTopY = playerCharacter.getWorldY() + playerCharacter.solidArea.y;
        int pBottomY = playerCharacter.getWorldY() + playerCharacter.solidArea.y + playerCharacter.solidArea.height;

        int pLeftCol = pLeftX / 50;
        int pRightCol = pRightX / 50;
        int pTopRow = pTopY / 50;
        int pBottomRow = pBottomY / 50;

        int tileNum1, tileNum2;

        switch (playerCharacter.direction) {

            case RIGHT:
                pRightCol = (pRightX + playerCharacter.getxVelocity()) / 50;
                tileNum1 = gp.tileManager.mapTileNum[pTopRow][pRightCol];
                tileNum2 = gp.tileManager.mapTileNum[pBottomRow][pRightCol];

                if ((gp.tileManager.tiles[tileNum1].collision && pTopY != pTopRow * 50) ||
                        (gp.tileManager.tiles[tileNum2].collision && pBottomY != pBottomRow * 50)) {

                    playerCharacter.collisionOn = true;
                }
                break;
            case LEFT:

                pLeftCol = (pLeftX + playerCharacter.getxVelocity()) / 50;
                tileNum1 = gp.tileManager.mapTileNum[pTopRow][pLeftCol];
                tileNum2 = gp.tileManager.mapTileNum[pBottomRow][pLeftCol];

                if ((gp.tileManager.tiles[tileNum1].collision && pTopY != pTopRow * 50) ||
                        (gp.tileManager.tiles[tileNum2].collision && pBottomY != pBottomRow * 50)) {

                    playerCharacter.collisionOn = true;
                }
                break;
        }

    }

    public void checkTileForJump(PlayerCharacter playerCharacter) {

        int pLeftX = playerCharacter.getWorldX() + playerCharacter.solidArea.x;
        int pRightX = playerCharacter.getWorldX() + playerCharacter.solidArea.x + playerCharacter.solidArea.width;
        int pTopY = playerCharacter.getWorldY() + playerCharacter.solidArea.y;
        int pBottomY = playerCharacter.getWorldY() + playerCharacter.solidArea.y + playerCharacter.solidArea.height;

        int pLeftCol = pLeftX / 50;
        int pRightCol = pRightX / 50;
        int pTopRow = pTopY / 50;
        int pBottomRow = pBottomY / 50;

        int tileNum1, tileNum2;

        tileNum1 = gp.tileManager.mapTileNum[pTopRow][pLeftCol];
        tileNum2 = gp.tileManager.mapTileNum[pTopRow][pRightCol];

        if (!playerCharacter.isJumpingUp()) {

            pBottomRow = (pBottomY + playerCharacter.getyVelocity()) /50;
            int tileNum3 = gp.tileManager.mapTileNum[pBottomRow][pRightCol];
            int tileNum4 = gp.tileManager.mapTileNum[pBottomRow][pLeftCol];
            int tileNum5 =gp.tileManager.mapTileNum[pBottomRow][pLeftCol - 1];

            if(gp.tileManager.tiles[tileNum4].collision) {

                playerCharacter.setyVelocity(0);
                playerCharacter.setWorldY((pBottomRow * 50) - 50);
                playerCharacter.firstHeightJump = 0;
                playerCharacter.setJumping(false);
                playerCharacter.setJumpingUp(false);
                playerCharacter.upPressed = false;
            }
            else if(gp.tileManager.tiles[tileNum3].collision){

                playerCharacter.setyVelocity(0);
                playerCharacter.setWorldX((pLeftCol * 50));
                playerCharacter.firstHeightJump = 0;
                playerCharacter.setJumpingUp(false);
                playerCharacter.upPressed = false;
            }
            else if(gp.tileManager.tiles[tileNum5].collision && (playerCharacter.getWorldX()+5) % 50 ==0){

                playerCharacter.setyVelocity(0);
                playerCharacter.setWorldX((pLeftCol * 50));
                playerCharacter.firstHeightJump = 0;
                playerCharacter.setJumpingUp(false);
                playerCharacter.upPressed = false;
            }
        }
        else {
            pTopRow = (pTopY + playerCharacter.getyVelocity()) / 50;
            int tileNum6 = gp.tileManager.mapTileNum[pTopRow][pLeftCol - 1];
            if(gp.tileManager.tiles[tileNum1].collision){

                playerCharacter.setyVelocity(0);
                playerCharacter.setWorldY(pBottomRow * 50);
                playerCharacter.firstHeightJump = 0;
                playerCharacter.setJumping(false);
                playerCharacter.upPressed = false;
            }
            else if(gp.tileManager.tiles[tileNum2].collision){

                playerCharacter.setyVelocity(0);
                playerCharacter.setWorldX((pLeftCol * 50));
                playerCharacter.firstHeightJump = 0;
                playerCharacter.upPressed = false;
            }
            else if(gp.tileManager.tiles[tileNum6].collision && (playerCharacter.getWorldX()+5 )% 50 ==0){

                playerCharacter.setyVelocity(0);
                playerCharacter.setWorldX((pLeftCol * 50));
                playerCharacter.firstHeightJump = 0;
                playerCharacter.upPressed = false;
            }
        }
    }

    public int checkObjectsCollision(PlayerCharacter playerCharacter , boolean isPlayer){

        int index= 1379;
        if(isPlayer) {

            for (int i = 0; i < gp.objects.length; i++) {
                if (gp.objects[i] != null) {

                    gp.objects[i].solidArea.x = gp.objects[i].getWorldX();
                    gp.objects[i].solidArea.y = gp.objects[i].getWorldY();
                    playerCharacter.solidArea.x = playerCharacter.getWorldX() + playerCharacter.solidArea.x;
                    playerCharacter.solidArea.y = playerCharacter.getWorldY() + playerCharacter.solidArea.y;

                    switch (playerCharacter.direction) {
                        case RIGHT :
                        case UPTORIGHT:
                            playerCharacter.solidArea.x += playerCharacter.getxVelocity();
                            break;
                        case LEFT:
                        case UPTOLEFT:
                            playerCharacter.solidArea.x -= playerCharacter.getxVelocity();
                            break;
                    }
                    if (playerCharacter.solidArea.intersects(gp.objects[i].solidArea)) {
                        playerCharacter.collidedWithObject = true;
                        index = i;
                    }
                    playerCharacter.solidArea.x = 5;
                    playerCharacter.solidArea.y = 10;
                    gp.objects[i].solidArea.x = 0;
                    gp.objects[i].solidArea.y = 0;
                }
            }
        }
        return index;
    }
}

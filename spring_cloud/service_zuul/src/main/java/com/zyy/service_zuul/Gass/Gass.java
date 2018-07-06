package com.zyy.service_zuul.Gass;

/**
 * @Description:
 * @Author: 郑玥延
 * @Date: 14:46 2018/7/6
 */

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Gass {
    static float[][] aa;//计算高斯后的权重矩阵
    final static int shu = 10;//高斯模糊半径
    final static int size = 2 * shu + 1;//数组大小


    /**
     * 简单高斯模糊算法
     *
     * @param args
     * @return void [返回类型说明]
     * @throws IOException [参数说明]
     * @throws throws      [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static void main(String[] args) throws IOException {

        aa = GaosiUtil.get2(GaosiUtil.get2DKernalData(shu, 1.5f));//计算高斯权重
        BufferedImage img = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));
        System.out.println("图片加载成功" + img);
        int height = img.getHeight();
        int width = img.getWidth();


        int[][] matrix = new int[size][size];//基础矩阵
        int[] values = new int[size * size];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                readPixel(img, i, j, values);//获取周边点的值
                fillMatrix(matrix, values);//将周边点个点的值存到缓存矩阵中
                img.setRGB(i, j, avgMatrix(matrix));
            }
        }
        ImageIO.write(img, "jpeg", new File("d:/test3.jpg"));//保存在d盘为test1.jpeg文件


    }


    private static void readPixel(BufferedImage img, int x, int y, int[] pixels) {//读取像素
        int xStart = x - shu;
        int yStart = y - shu;
        int current = 0;
        for (int i = xStart; i < size + xStart; i++) {
            for (int j = yStart; j < size + yStart; j++) {
                int tx = i;
                if (tx < 0)//处理边界情况左溢出
                {
                    tx = -tx;
                } else if (tx >= img.getWidth())//处理边界情况右溢出
                {
                    tx = x;
                }

                int ty = j;
                if (ty < 0) {
                    ty = -ty;
                } else if (ty >= img.getHeight()) {
                    ty = y;
                }
                pixels[current++] = img.getRGB(tx, ty);//获取

            }
        }
    }

    private static void fillMatrix(int[][] matrix, int... values) {
        int filled = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = values[filled++];
            }
        }
    }

    private static int avgMatrix(int[][] matrix) {
        int r = 0;
        int g = 0;
        int b = 0;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {

                Color c = new Color(matrix[i][j]);
                r += c.getRed() * aa[i][j];
                g += c.getGreen() * aa[i][j];
                b += c.getBlue() * aa[i][j];
            }

        }

        return new Color(r, g, b).getRGB();
    }
}

class GaosiUtil {
    //二维高斯算法具体实现
    static float sum = 0;

    public static float[][] get2DKernalData(int n, float sigma) {
        int size = 2 * n + 1;
        float sigma22 = 2 * sigma * sigma;
        float sigma22PI = (float) Math.PI * sigma22;
        float[][] kernalData = new float[size][size];


        int row = 0;
        for (int i = -n; i <= n; i++) {
            int column = 0;
            for (int j = -n; j <= n; j++) {
                float xDistance = i * i;
                float yDistance = j * j;
                kernalData[row][column] = (float) Math.exp(-(xDistance + yDistance) / sigma22) / sigma22PI;
                column++;
            }
            row++;
        }
        System.out.println("二维高斯结果");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += kernalData[i][j];
                System.out.print("\t" + kernalData[i][j]);
            }
            System.out.println();
            System.out.println("\t ---------------------------");
        }
        return kernalData;
    }

    public static float[][] get2(float[][] kernalData) {
        System.out.println("均值后");
        for (int i = 0; i < kernalData.length; i++) {
            for (int j = 0; j < kernalData.length; j++) {
                kernalData[i][j] = kernalData[i][j] / sum;
                System.out.print("\t" + kernalData[i][j]);
            }
            System.out.println();
            System.out.println("\t ---------------------------");
        }
        return kernalData;

    }


}
package com.yt.demo.helper.util.print;/**
 * Created by SUN on 19/4/7.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author SUN
 * @create 2019-04-07 上午10:11
 * @desc
 */
public class PrintHelper {

    private static final String EMPTY_STRING = "";

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintHelper.class);

    public static String printStack(SequenceDiagram sequenceDiagram) {
        if (null == sequenceDiagram) {
            LOGGER.warn("sequenceDiagram is null");
            return EMPTY_STRING;
        }
        List<LifePointer> pointers =  sequenceDiagram.getPointers();
        if (null == pointers && pointers.isEmpty()) {
            LOGGER.warn("sequenceDiagram.getPointers is null or empty");
            return EMPTY_STRING;
        }
        Map<String, LifeLine> lifeLineMap = sequenceDiagram.getLifeLineMap();
        if (null == lifeLineMap && lifeLineMap.isEmpty()) {
            LOGGER.warn("sequenceDiagram.getLifeLineMap is null or empty");
            return EMPTY_STRING;
        }
        LifeLine[] printedLifeLines = sequenceDiagram.getPrintedLifeLines();

        StringBuilder printer = new StringBuilder();
        boolean hasError = false;
        int curPrintedLifeLineCounter = 0;
        for (LifePointer pointer : pointers) {
            String startLifeLineFullPath = pointer.getStartLifeLineFullPath();
            String endLifeLineFullPath = pointer.getEndLifeLineFullPath();
            if (null == startLifeLineFullPath || startLifeLineFullPath.isEmpty()) {
                LOGGER.error("startLifeLineFullPath is null");
                hasError = true;
                break;
            }
            if (null == endLifeLineFullPath || endLifeLineFullPath.isEmpty()) {
                LOGGER.error("endLifeLineFullPath is null");
                hasError = true;
                break;
            }
            LifeLine startLifeLine = lifeLineMap.get(startLifeLineFullPath);
            LifeLine endLifeLine = lifeLineMap.get(endLifeLineFullPath);
            if (null == startLifeLine || null == endLifeLine) {
                LOGGER.error("startLifeLine or endLifeLine is null");
                hasError = true;
                break;
            }
            if (!startLifeLine.isPrinted()) {
                startLifeLine.setPrintIndex(curPrintedLifeLineCounter);
                printedLifeLines[curPrintedLifeLineCounter++] = startLifeLine;
            }
            if (!endLifeLine.isPrinted()) {
                endLifeLine.setPrintIndex(curPrintedLifeLineCounter);
                printedLifeLines[curPrintedLifeLineCounter++] = endLifeLine;
            }

            int startPosition = getPosition(startLifeLine, printedLifeLines);
            int endPosition = getPosition(endLifeLine, printedLifeLines);
            printPointer(printer, startPosition, endPosition);
        }
        if (hasError) {
            return EMPTY_STRING;
        }

        StringBuilder header = new StringBuilder();
        for (int i = 0; i < printedLifeLines.length; i++) {
            if (SequenceDiagram.isPrintPackage) {
                header.append(printedLifeLines[i].getFullKey());
            } else {
                header.append(printedLifeLines[i].className);
            }
            for (int j = 0; j < SequenceDiagram.LIFELIFE_ABSOLUTE_DISTANCE; j++) {
                header.append(" ");
            }
        }
        header.append("\r\n");

        return header.append(printer).toString();
    }

    private static int getPosition(LifeLine port, LifeLine[] printedLifeLines) {
        int index = port.getPrintIndex();
        int length = 0;
        for (int i = 0; i < index; i++) {
            if (SequenceDiagram.isPrintPackage) {
                length += printedLifeLines[i].getPackagePathLength();
            }
            length += printedLifeLines[i].getClassNameLength();
            length += SequenceDiagram.LIFELIFE_ABSOLUTE_DISTANCE;
        }
        return length;
    }

    private static void printPointer(StringBuilder printer, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            for (int i = 0; i < startIndex; i++) {
                printer.append(" ");
            }
            for (int i = startIndex; i < endIndex; i++) {
                printer.append("-");
            }
            printer.append(">");
            printer.append("\r\n");
        } else {
            for (int i = 0; i < endIndex; i++) {
                printer.append(" ");
            }
            printer.append("<");
            for (int i = endIndex; i < startIndex; i++) {
                printer.append("-");
            }
            printer.append("\r\n");
        }
    }
}

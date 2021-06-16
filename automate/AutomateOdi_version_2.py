from pynput.mouse import Listener
import pyautogui
import pyperclip
import time
import keyboard

clicks = 0
lastColumnPosition = {"x": 0, "y": 0}
expressionPosition = {"x": 0, "y": 0}
lastColumnAvalied = ""
clicksDictionary = {"clicks": 0}



def on_click(x, y, button, pressed):

    if pressed:
        clicksDictionary["clicks"] = clicksDictionary["clicks"] + 1

    if clicksDictionary["clicks"] == 1:
        lastColumnPosition["x"] = x
        lastColumnPosition["y"] = y


    if clicksDictionary["clicks"] == 2:
        expressionPosition["x"] = x
        expressionPosition["y"] = y
        listener.stop()


    print(lastColumnPosition, " ", expressionPosition)

    print(x, y, button, pressed)



with Listener(on_click=on_click) as listener:
    print("event")
    listener.join()

totalPresses = 1
cont = 0

while(cont < 2):

    pyautogui.moveTo(lastColumnPosition["x"], lastColumnPosition["y"])
    pyautogui.click()
    for i in range(0, totalPresses):
        keyboard.press_and_release('down')

    time.sleep(0.7)
    pyautogui.moveTo(expressionPosition["x"], expressionPosition["y"])
    pyautogui.click()

    keyboard.press_and_release("ctrl+a")
    time.sleep(.3)
    keyboard.press_and_release("ctrl+c")
    time.sleep(.3)

    copiedText = pyperclip.paste()

    print(copiedText)

    textToPaste = "zeroifnull(" + copiedText + ")"

    if lastColumnAvalied == copiedText:
        print("breaking loop")
        break
    else:
        lastColumnAvalied = "zeroifnull(" + copiedText + ")"

    #time.sleep(.1)
    pyautogui.write(textToPaste)

    totalPresses = totalPresses + 1
    cont = cont + 1
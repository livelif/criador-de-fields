from pynput.mouse import Listener
import pyautogui
import pyperclip
import time

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

while(True):

    pyautogui.moveTo(lastColumnPosition["x"], lastColumnPosition["y"])
    pyautogui.click()
    pyautogui.press('down', presses=totalPresses)

    pyautogui.moveTo(expressionPosition["x"], expressionPosition["y"])
    pyautogui.click()
    totalPresses = totalPresses + 1

    pyautogui.hotkey("ctrl", "a")
    time.sleep(.01)
    pyautogui.hotkey("ctrl", "c")
    time.sleep(.01)

    copiedText = pyperclip.paste()
    textToPaste = "zeroifnull(" + copiedText + ")"

    if lastColumnAvalied == copiedText:
        print("breaking loop")
        break
    else:
        lastColumnAvalied = "zeroifnull(" + copiedText + ")"

    pyautogui.write(textToPaste)
    time.sleep(.01)

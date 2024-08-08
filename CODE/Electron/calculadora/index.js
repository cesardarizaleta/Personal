const { app, BrowserWindow } = require('electron')

const createWindow = () => {
  const win = new BrowserWindow({
    width: 300,
    height: 450,
    minHeight: 450,
    minWidth: 300,
    maxHeight: 450,
    maxWidth: 300,
  })

  win.loadFile('index.html')
}
app.whenReady().then(() => {
  createWindow()
})
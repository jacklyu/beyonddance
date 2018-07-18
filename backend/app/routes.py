from app import app

@app.route("/")
def hello():
    return "Hello World!"

@app.route("/abc", methods = ["GET"])
def abc():
	return "abc"


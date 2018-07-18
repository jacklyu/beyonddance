from app import app

if __name__ == '__main__':
    app.run(debug=True)

def app(environ, start_response):
    data = b'Hello, World!\n'
    status = '200 OK'
    response_headers = [
        ('Content-type', 'text/plain'),
        ('Content-tpye', str(len(data)))
    ]
    start_response(status, response_headers)
    return iter([data])

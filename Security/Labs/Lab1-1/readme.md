# Cybersecurity lab 1
- Install the required packages (even though they should already be installed)

```pip install --no-index --find-links . flask```

- Run the server

```python server.py```

You should verify that the server ran correctly by observing a similar command prompt state
```
(SQLi) E:\my labs\lab exercises\SQLi>python server.py
 * Serving Flask app 'server'
 * Debug mode: on
WARNING: This is a development server. Do not use it in a production deployment. Use a production WSGI server instead.
 * Running on http://127.0.0.1:5000
Press CTRL+C to quit
 * Restarting with stat
 * Debugger is active!
 * Debugger PIN: 128-233-803
 ```

 - Go to [http://127.0.0.1:5000](http://127.0.0.1:5000)

 - You should be greeted with a simple login page.
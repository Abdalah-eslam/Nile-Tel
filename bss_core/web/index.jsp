<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World – Java EE</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body {
            font-family: Arial, Helvetica, sans-serif;
            background: linear-gradient(135deg, #1a1a2e 0%, #16213e 50%, #0f3460 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #eee;
        }
        .card {
            background: rgba(255,255,255,0.07);
            backdrop-filter: blur(12px);
            border: 1px solid rgba(255,255,255,0.15);
            border-radius: 16px;
            padding: 3rem 4rem;
            text-align: center;
            box-shadow: 0 8px 32px rgba(0,0,0,0.4);
        }
        h1 { font-size: 2.4rem; color: #e94560; margin-bottom: 1rem; }
        p  { font-size: 1.1rem; color: #ccc; margin-bottom: 1.5rem; }
        a.btn {
            display: inline-block;
            padding: 0.75rem 2rem;
            background: #e94560;
            color: #fff;
            text-decoration: none;
            border-radius: 8px;
            font-weight: bold;
            transition: background 0.2s;
        }
        a.btn:hover { background: #c73652; }
    </style>
</head>
<body>
    <div class="card">
        <h1>Hello World from Java EE!</h1>
        <p>Welcome to your Ant-based Java EE web application.</p>
        <a class="btn" href="${pageContext.request.contextPath}/hello">Visit Servlet → /hello</a>
    </div>
</body>
</html>

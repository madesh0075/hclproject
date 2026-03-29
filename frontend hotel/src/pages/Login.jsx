import { useState } from "react";
import Register from "./Register";
import AdminRegister from "./AdminRegister";

function Login({ setUser }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [showRegister, setShowRegister] = useState(false);
  const [showAdminRegister, setShowAdminRegister] = useState(false);

  // 🔥 ADMIN LOGIN
  const handleAdminLogin = async () => {
    try {
      const res = await fetch("http://localhost:8080/admin/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password }),
      });

      if (res.status === 200) {
        const data = await res.json();
        setUser(data);
      } else {
        alert("Invalid Admin credentials");
      }
    } catch (err) {
      console.error(err);
      alert("Server error");
    }
  };

  // 🔥 USER LOGIN
  const handleUserLogin = async () => {
    try {
      const res = await fetch("http://localhost:8080/user/user-login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password }),
      });

      const text = await res.text();

      if (text === "Login Success") {
        setUser({
          email,
          role: "USER",
          id: 1,
        });
      } else {
        alert("Invalid User credentials");
      }
    } catch (err) {
      console.error(err);
      alert("Server error");
    }
  };

  // 👉 USER REGISTER
  if (showRegister) {
    return <Register setShowRegister={setShowRegister} />;
  }

  // 👉 ADMIN REGISTER
  if (showAdminRegister) {
    return <AdminRegister setShowLogin={setShowAdminRegister} />;
  }

  return (
    <div>
      <h2>Login</h2>

      <input
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <br />

      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <br /><br />

      {/* 🔥 TWO LOGIN BUTTONS */}
      <button onClick={handleUserLogin}>User Login</button>
      <button onClick={handleAdminLogin}>Admin Login</button>

      <p>
        Don't have account?{" "}
        <button onClick={() => setShowRegister(true)}>
          Register as User
        </button>
      </p>

      <p>
        Admin?{" "}
        <button onClick={() => setShowAdminRegister(true)}>
          Register as Admin
        </button>
      </p>
    </div>
  );
}

export default Login;
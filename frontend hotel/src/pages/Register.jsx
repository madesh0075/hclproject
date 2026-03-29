import { useState } from "react";

function Register({ setShowRegister }) {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleRegister = async () => {
    await fetch("http://localhost:8080/user/adduser", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username, email, password }),
    });

    alert("Registered!");
    setShowRegister(false);
  };

  return (
    <div>
      <h2>Register</h2>

      <input placeholder="Username" onChange={(e) => setUsername(e.target.value)} />
      <br />
      <input placeholder="Email" onChange={(e) => setEmail(e.target.value)} />
      <br />
      <input type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)} />
      <br />

      <button onClick={handleRegister}>Register</button>
    </div>
  );
}

export default Register;
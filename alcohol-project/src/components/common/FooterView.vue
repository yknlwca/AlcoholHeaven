<template>
  <div>
    <footer>
      <div class="footer-container">
        <div class="footer-logo">
          <img src="@/assets/img/알코올천국로고_최종.png" alt="Company Logo" />
        </div>
        <div class="footer-links">
          <h4>주요 링크</h4>
          <ul>
            <li><a href="#about">About Us</a></li>
            <li><a href="#products">Products</a></li>
            <li><a href="#contact">Contact</a></li>
            <li><a href="#faq">FAQ</a></li>
          </ul>
        </div>
        <div class="footer-social">
          <h4>Follow Us</h4>
          <a href="https://facebook.com" target="_blank">Facebook</a>
          <a href="https://twitter.com" target="_blank">Twitter</a>
          <a href="https://instagram.com" target="_blank">Instagram</a>
        </div>
        <div class="footer-contact">
          <h4>Contact Us</h4>
          <p>Phone: 123-456-7890</p>
          <p>Email: info@company.com</p>
        </div>
      </div>
      <div class="footer-bottom">
        <p>&copy; 2024 Company Name. All rights reserved.</p>
      </div>
    </footer>
  </div>
</template>

<script setup></script>

<style scoped>
footer {
  background-color: #01AD6F;
  color: white;
  padding: 20px 0;
}

.footer-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  padding: 20px;
  max-width: 1200px;
  margin: 0 auto;
}

.footer-logo img {
  max-width: 150px;
}

.footer-links, .footer-social, .footer-contact {
  flex: 1 1 200px;
  margin: 10px;
}

.footer-links ul, .footer-social a {
  list-style: none;
  padding: 0;
  margin: 0;
}

.footer-links ul li, .footer-social a {
  margin: 5px 0;
}

.footer-links a, .footer-social a {
  color: white;
  text-decoration: none;
}

.footer-links a:hover, .footer-social a:hover {
  text-decoration: underline;
}

.footer-bottom {
  text-align: center;
  padding: 10px;
  border-top: 1px solid rgba(255, 255, 255, 0.2);
}

.footer-bottom p {
  margin: 0;
}
</style>

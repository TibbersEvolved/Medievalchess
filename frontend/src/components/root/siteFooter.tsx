export default function SiteFooter() {
  return (
    <footer className="footer footer-center bg-base-300 text-base-content p-2  relative bottom-0">
      <aside>
        <p>
          Copyright © {new Date().getFullYear()} - All right reserved by Erik
          Olin
        </p>
      </aside>
    </footer>
  );
}

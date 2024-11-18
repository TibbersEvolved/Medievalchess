import * as React from "react";
import { createFileRoute } from "@tanstack/react-router";
import GameInfoPlayer from "../components/game/gameSelect/gameInfoPlayer";
import GameInfo from "../components/game/gameSelect/gameInfo";

export const Route = createFileRoute("/")({
  component: HomeComponent,
});

function HomeComponent() {
  return (
    <div className="p-2 text-center">
      <h3 className="text-4xl">Welcome to Medieval Chess!</h3>
      <section className="mt-3 mx-5">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Odio itaque
        amet eum omnis repellat, nostrum nam modi, ipsum qui minima odit quis
        est saepe cupiditate nemo fugiat quod ipsam ea? Quae doloremque at
        exercitationem, suscipit id, quibusdam provident nisi quia natus ipsam
        harum officiis doloribus veritatis cumque praesentium consequuntur,
        culpa assumenda eligendi tempore molestiae maiores eius. Vero doloremque
        doloribus iure? Quae totam doloribus obcaecati libero veniam, tempore,
        odit impedit nesciunt commodi, ratione autem est asperiores corporis
        dolores amet? Ipsa, expedita? At aliquid accusamus animi est natus
        expedita eos ducimus odit. Vero necessitatibus maxime adipisci?
        Excepturi obcaecati rerum atque, quaerat magnam hic, consequatur, quidem
        adipisci dolore error unde tempora nostrum! Est pariatur magnam fugit
        veniam cum temporibus voluptates, deserunt laboriosam accusamus?
        Nostrum, quaerat? At obcaecati aut eligendi sequi, assumenda omnis est
        quam eum exercitationem eius vitae quaerat unde ad veniam nisi in
        molestias numquam error quod blanditiis minus. Voluptates, molestias
        ipsam?
      </section>
      <section className="mt-4 mx-5">
        Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fugiat aliquam
        reprehenderit dolorum vel, natus doloremque laboriosam perferendis a?
        Tenetur distinctio magnam vitae rem dignissimos culpa sunt dolore labore
        natus adipisci? At a iste maxime labore nam provident ipsa laudantium,
        exercitationem nihil tempore? Veritatis dolor qui recusandae iusto
        temporibus excepturi ipsa, voluptatem dolorum voluptates doloremque
        maiores aliquid eaque assumenda sunt harum? Mollitia nihil et minima
        corporis odit, quos fugit totam officiis sit nam qui minus aperiam quod.
        Hic recusandae error quibusdam, quam commodi minima eius quasi libero
        labore excepturi, optio sit. Nesciunt, unde sapiente deleniti omnis
        eveniet laborum at magnam nobis similique, molestias dicta deserunt
        reiciendis! In quia sed fugiat at error esse, amet praesentium
        laboriosam veritatis, animi tempora. Quisquam, deserunt. Magni, minima
        dolor repellendus nam accusantium, obcaecati reprehenderit sapiente
        soluta quis non necessitatibus nobis, architecto rem. Excepturi expedita
        tempora voluptas eos. Neque aliquid explicabo facere. Dolorem expedita
        voluptatum ipsa eius.
      </section>
    </div>
  );
}
